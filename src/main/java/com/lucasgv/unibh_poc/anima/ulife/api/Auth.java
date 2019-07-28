package com.lucasgv.unibh_poc.anima.ulife.api;

import com.lucasgv.unibh_poc.http.Requisicao;
import com.lucasgv.unibh_poc.http.TipoRequisicao;
import com.lucasgv.unibh_poc.util.Propriedade;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 04/03/2019
 * Time: 01:21
 * To change this template use File | Settings | File and Code Templates.
 */
public class Auth {
    private final Propriedade config = new Propriedade("ulife.api.properties");
    private final static Logger logger = LogManager.getLogger(com.lucasgv.unibh_poc.anima.ulife.api.Auth.class);
    private Requisicao req = new Requisicao();
    @Getter @Setter private String ra, senha;
    @Setter private String cookie;
    @Getter @Setter private String viewState;

    public Auth(String ra, String senha) {
        this.ra = ra;
        this.senha = senha;
        req.setIgnoreContentType(true);
        req.setBaseURL("https://www.ulife.com.br");
        req.setEndpoint("/Login.aspx");
        req.setTipo(TipoRequisicao.GET);
        try {
            this.setViewState(req.enviar().parse().body().getElementById("__VIEWSTATE").val());
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        logger.info("Iniciando autenticação no Ulife...");
    }

    public String getCookie(){
        logger.info("Tentando obter o cookie...");
        String cookie = null;
        try {
            req.setEndpoint("/Login.aspx");
            req.addHeader("Content-Type", MediaType.APPLICATION_FORM_URLENCODED);
            req.addPayload("ctl00$b$txtLogin", this.getRa());
            req.addPayload("ctl00$b$txtPassword", this.getSenha());
            req.addPayload("ctl00$b$imbLogin", "Entrar");
            req.addPayload("__VIEWSTATE", this.getViewState());
            req.setTipo(TipoRequisicao.POST);
            cookie = req.enviar().cookie("frmLogin");
            logger.info(new StringBuilder("O token foi obtido com sucesso! -> ").append(cookie));

        } catch(Exception e){
            logger.error(new StringBuilder("Problema ao gerar token: ").append(e));
        }
        this.setCookie(cookie);
        return cookie;
    }

    public String getDisciplinas(){
        String html = null;
        try {
            req.setBaseURL(this.config.getBaseURL());
            req.setEndpoint("/Student/Disciplines?modulestepvalue=-2&organizationcourseid=-1");
            req.addHeader("Content-Type", MediaType.APPLICATION_JSON);
            req.addHeader("Cookie", new StringBuilder("frmLogin=").append(this.cookie).toString());
            req.setTipo(TipoRequisicao.GET);
            html = req.enviar().parse().body().html();
        } catch(Exception e){
            logger.error(new StringBuilder("Problema ao gerar token: ").append(e));
        }
        return html;
    }
}
