package com.lucasgv.unibh_poc.anima.laiv.abstractlaiv;

import lombok.Setter;
import lombok.Getter;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 10/02/2019
 * Time: 20:11
 * To change this template use File | Settings | File and Code Templates.
 */
public abstract class AbstractLAIVMap {
    @Getter @Setter private String nome, descricao, decimalId, hashId, mapId;

    public AbstractLAIVMap(String nome, String descricao, String decimalId, String hashId) {
        this(nome, descricao, decimalId, hashId, "1422cfe3-6b9e-4f75-ab9b-ec63136ffb3f");
    }

    public AbstractLAIVMap(String nome, String descricao, String decimalId, String hashId, String mapId) {
        this.nome = nome;
        this.descricao = descricao;
        this.decimalId = decimalId;
        this.hashId = hashId;
        this.mapId = mapId;
    }
}
