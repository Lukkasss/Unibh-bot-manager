package com.lucasgv.unibh_poc.util;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 10/02/2019
 * Time: 19:23
 * To change this template use File | Settings | File and Code Templates.
 */
public class Charset {
    public static String convertUTF8toISO(String str) {
        String ret = null;
        try {
            ret = new String(str.getBytes("ISO-8859-1"), "UTF-8");
        }
        catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return ret;
    }
}
