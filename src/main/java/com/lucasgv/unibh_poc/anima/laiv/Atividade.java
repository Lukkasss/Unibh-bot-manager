package com.lucasgv.unibh_poc.anima.laiv;

import com.lucasgv.unibh_poc.anima.api.Auth;
import com.lucasgv.unibh_poc.anima.laiv.abstractlaiv.AbstractLAIVMap;
import com.lucasgv.unibh_poc.http.Requisicao;
import com.lucasgv.unibh_poc.http.TipoRequisicao;
import com.lucasgv.unibh_poc.parse.JSON;
import com.lucasgv.unibh_poc.util.Propriedade;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 10/02/2019
 * Time: 05:11
 * To change this template use File | Settings | File and Code Templates.
 */
public class Atividade extends AbstractLAIVMap {

    @Getter @Setter int pontosAtividade;
    private final Propriedade config = new Propriedade("laiv.properties");
    private final static Logger logger =  LogManager.getLogger(Atividade.class);
    private Requisicao req = new Requisicao();

    public Atividade(String nome, String descricao, String decimalId, String hashId, int pontosAtividade) {
        super(nome, descricao, decimalId, hashId);
        this.pontosAtividade = pontosAtividade;
    }

    public Atividade(String nome, String descricao, String decimalId, String hashId, String mapId, int pontosAtividade) {
        super(nome, descricao, decimalId, hashId, mapId);
        this.pontosAtividade = pontosAtividade;
    }

    //isso aqui tem q ficar na classe LAIV
    public List<String> getAtividades(){
        req.setEndpoint("/ulife/JSON/CustomerItinerarySpot/buildAllTracksForUserMap");
        req.setIgnoreContentType(true);
        req.setBaseURL(config.getBaseURL());
        req.setTipo(TipoRequisicao.POST);
        req.addHeader("auth-token", "816532730609B86C03A6F42C7623F980");
        req.addPayload("objectPass", "{\"idMap\":\"1422cfe3-6b9e-4f75-ab9b-ec63136ffb3f\"}");
    //    return JSON.parseArray(req.enviar(), "formativeItineraryList", "name");
        return null;
    }

    public static void main(String[] args) {
       /* Atividade a = new Atividade();
        for (Object b:a.getAtividades()) {
            System.out.println(b);
        }*/
    }
}
