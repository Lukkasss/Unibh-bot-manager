package com.lucasgv.unibh_poc.anima.laiv;

import com.lucasgv.unibh_poc.anima.laiv.abstractlaiv.AbstractLAIVMap;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 10/02/2019
 * Time: 19:59
 * To change this template use File | Settings | File and Code Templates.
 */
public class Trilha extends AbstractLAIVMap {
    @Getter @Setter private List<Estacao> estacao;

    public Trilha(String nome, String descricao, String decimalId, String hashId) {
        super(nome, descricao, decimalId, hashId);
    }
}
