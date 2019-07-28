package com.lucasgv.unibh_poc.anima.ulife;

import lombok.Setter;
import lombok.Getter;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 04/03/2019
 * Time: 01:13
 * To change this template use File | Settings | File and Code Templates.
 */
public class Disciplinas {

    @Getter @Setter private Integer studentClassDisciplineId, classDisciplineId, disciplineContentId, organizationId,
                                    disciplineId, disciplineName, classId, className;

    public Disciplinas(Integer disciplineName) {
        this.disciplineName = disciplineName;
    }

    public Disciplinas(Integer studentClassDisciplineId, Integer classDisciplineId, Integer disciplineContentId,
                       Integer organizationId, Integer disciplineId, Integer disciplineName, Integer classId,
                       Integer className) {

        this.studentClassDisciplineId = studentClassDisciplineId;
        this.classDisciplineId = classDisciplineId;
        this.disciplineContentId = disciplineContentId;
        this.organizationId = organizationId;
        this.disciplineId = disciplineId;
        this.disciplineName = disciplineName;
        this.classId = classId;
        this.className = className;
    }
}
