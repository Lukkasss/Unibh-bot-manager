package com.lucasgv.unibh_poc.anima.ulife;


import com.lucasgv.unibh_poc.anima.ulife.api.Auth;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 04/03/2019
 * Time: 01:19
 * To change this template use File | Settings | File and Code Templates.
 */
public class Ulife {

    @Getter @Setter private String authCookie;
    Auth ulifeAuth = new Auth("11823934", "se");

    public Ulife() {
        this.authCookie = ulifeAuth.getCookie();

    }

    public String getDisciplinas(){
        return ulifeAuth.getDisciplinas();
    }
}
