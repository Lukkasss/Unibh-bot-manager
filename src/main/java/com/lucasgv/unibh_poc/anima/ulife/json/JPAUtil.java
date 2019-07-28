package com.lucasgv.unibh_poc.anima.ulife.json;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 23/03/2019
 * Time: 01:02
 * To change this template use File | Settings | File and Code Templates.
 */
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final String PERSISTENCE_UNIT_NAME = "HibernateTutorialPU";
    private static EntityManagerFactory factory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("HibernateTutorialPU");
        }
        return factory;
    }

    public static void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}