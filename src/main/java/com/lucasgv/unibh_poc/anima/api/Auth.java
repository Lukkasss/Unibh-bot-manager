package com.lucasgv.unibh_poc.anima.api;
import com.lucasgv.unibh_poc.http.Requisicao;
import com.lucasgv.unibh_poc.http.TipoRequisicao;
import com.lucasgv.unibh_poc.util.*;
import com.lucasgv.unibh_poc.parse.JSON;
import javax.ws.rs.core.MediaType;
import lombok.Setter;
import lombok.Getter;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 10/02/2019
 * Time: 00:14
 * To change this template use File | Settings | File and Code Templates.
 */
public class Auth {
    private final Propriedade config = new Propriedade("api.properties");
    private final static Logger logger = LogManager.getLogger(Auth.class);
    private Requisicao req = new Requisicao();
    @Getter @Setter private Integer instituicao;
    @Getter @Setter private String ra, senha;

    public Auth(String ra, String senha) {
        this(TipoInstituicao.UNIBH.getCodigo(), ra, senha);
    }

    public Auth(Integer instituicao, String ra, String senha) {
        this.instituicao = instituicao;
        this.ra = ra;
        this.senha = senha;
        req.setBaseURL(config.getBaseURL());
        req.setIgnoreContentType(true);
        logger.info("Iniciando autenticação...");
    }

    public String getToken(){
        logger.info("Tentando obter o token...");
        String token = null;
        try {
            String credenciais = Encode.base64(new StringBuilder(config.getLogin()).append(":").append(config.getSenha()).toString());
            req.setEndpoint("/academico/token");
            req.addHeader("Content-Type", MediaType.APPLICATION_FORM_URLENCODED);
            req.addHeader("Authorization", new StringBuilder("Basic ").append(credenciais).toString());
            req.addPayload("ra", this.getRa());
            req.addPayload("senha", Encode.base64(this.getSenha()));
            req.addPayload("instituicao", this.getInstituicao().toString());
            req.setTipo(TipoRequisicao.POST);
        //    token = JSON.parse(req.enviar(), "token");
            logger.info(new StringBuilder("O token foi obtido com sucesso! -> ").append(token));

        } catch(Exception e){
            logger.error(new StringBuilder("Problema ao gerar token: ").append(e));
        }
        return token;
    }
}
