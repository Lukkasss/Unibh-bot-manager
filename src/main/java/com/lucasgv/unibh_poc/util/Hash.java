package com.lucasgv.unibh_poc.util;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 06/02/2019
 * Time: 11:28
 * To change this template use File | Settings | File and Code Templates.
 */
public class Hash {
    public static boolean verificar(String valor){
        return valor.matches("^[a-fA-F0-9]{32}$");
    }
}
