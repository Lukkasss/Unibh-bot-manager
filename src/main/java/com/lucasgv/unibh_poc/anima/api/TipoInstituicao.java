package com.lucasgv.unibh_poc.anima.api;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 10/02/2019
 * Time: 01:09
 * To change this template use File | Settings | File and Code Templates.
 */
public enum TipoInstituicao {
    UNIBH(1);

    private final int codigo;

     TipoInstituicao(int codigo){
        this.codigo = codigo;
    }

    public int getCodigo(){
         return this.codigo;
    }
}
