package com.lucasgv.unibh_poc.util;
import java.util.Base64;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 06/02/2019
 * Time: 11:09
 * To change this template use File | Settings | File and Code Templates.
 */
public class Encode{
    /**
     * Retorna o valor convertido para Base64.
     * @param valor valor a ser convertido
     * @return valor convertido em base64
     *
     */
    public static String base64(String valor){
        return Base64.getEncoder().encodeToString(valor.getBytes());
    }
}
