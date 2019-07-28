package com.lucasgv.unibh_poc.anima.laiv;

import com.lucasgv.unibh_poc.util.Propriedade;
import lombok.Setter;
import lombok.Getter;
import java.util.List;
import com.lucasgv.unibh_poc.http.*;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 10/02/2019
 * Time: 05:07
 * To change this template use File | Settings | File and Code Templates.
 */
public class LAIV {

    @Getter @Setter private List<Trilha> trilhas;
    @Getter @Setter private String token;
    Requisicao req = new Requisicao();
    private final Propriedade config = new Propriedade("laiv.properties");

    public LAIV(String token) {
        this(token, null);
    }

    public LAIV(String token, List<Trilha> trilhas) {
        this.trilhas = trilhas;
        this.token = token;
    }

    public void login(){
        String payload = new StringBuilder("?objectPass={\"token\":\"").append(this.getToken())
                .append("\",\"userName\":\"11985279606\"}").toString();
        req.setBaseURL(config.getBaseURL());
        req.setTipo(TipoRequisicao.GET);
        //req.addPayload("objectPass", payload);
        req.setEndpoint("/index.html#/" + payload);
        System.out.println(req.enviar());
        req.addHeader("auth-token", this.getToken());
        req.setBaseURL("https://ulifeserver.tamboro.com.br");
        req.setEndpoint("/ulife/JSON/FormativeItinerary/listUserItineraries");
        req.setTipo(TipoRequisicao.POST);
        payload = new StringBuilder("{\"idMap\":\"1422cfe3-6b9e-4f75-ab9b-ec63136ffb3f\"}").toString();
        req.addPayload("objectPass", payload);
        System.out.println(req.enviar());
    }

    public List<Trilha> getListaTrilhas(){
        return this.trilhas;
    }
}
