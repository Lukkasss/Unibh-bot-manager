package com.lucasgv.unibh_poc.anima.ulife.json;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 04/03/2019
 * Time: 09:36
 * To change this template use File | Settings | File and Code Templates.
 */
public class Result2 {
    @Getter @Setter List<Result> results;

    public Result2() {
    }

    public Result2(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Result2{" +
                "results=" + results +
                '}';
    }
}
