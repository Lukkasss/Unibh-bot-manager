package com.lucasgv.unibh_poc.anima.ulife.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 04/03/2019
 * Time: 07:52
 * To change this template use File | Settings | File and Code Templates.
 */

@Entity
@Table(name = "materias")

public class Result {
    @JsonProperty("DisciplineName")
    @Column(name = "discipline_name", unique = true)
    @Getter @Setter private String disciplineName;
    @JsonProperty("ClassID")
    @Column(name = "class_id", unique = true)
    @Getter @Setter private Integer classId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter private int id;


    public Result() {
    }

    public Result(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    @Override
    public String toString() {
        return "Result{" +
                "disciplineName='" + disciplineName + '\'' +
                ", classId=" + classId +
                '}';
    }
}
