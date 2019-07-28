package com.lucasgv.unibh_poc.anima.ulife.json;
import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Lucas Vilela
 * Date: 23/03/2019
 * Time: 00:52
 * To change this template use File | Settings | File and Code Templates.
 */
/**
 *  JPA CRUD Operations
 * @author Ramesh Fadatare
 *
 */
public class entitymanager {

    public void insertEntity(Result r) {
        Result r = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("teste");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        Query q = entityManager.createQuery("SELECT class_id FROM materias WHERE materias.class_id=:r");

        entityTransaction.begin();
        entityManager.persist(r);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void findEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Result r = entityManager.find(Result.class, 0);
        System.out.println(" id :: " + r.getId());
        System.out.println(" classid :: " + r.getClassId());
        System.out.println(" disciplinename :: " + r.getDisciplineName());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Result r = entityManager.find(Result.class, 1);
        System.out.println(" id :: " + r.getId());
        System.out.println(" classid :: " + r.getClassId());
        System.out.println(" disciplinename :: " + r.getDisciplineName());

        // The entity object is physically updated in the database when the transaction
        // is committed
        //student.setFirstName("Ram");
        //student.setLastName("jadhav");
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeEntity() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Result r = entityManager.find(Result.class, 1);
        System.out.println(" id :: " + r.getId());
        System.out.println(" classid :: " + r.getClassId());
        System.out.println(" disciplinename :: " + r.getDisciplineName());
        entityManager.remove(r);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}