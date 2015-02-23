package org.mimo.repository;

import org.mimo.repository.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.JpaQueryCreator;
import org.springframework.data.jpa.repository.query.JpaQueryMethod;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;

/**
 * Created by Mirsad on 22.02.2015.
 */

public class ExtPersonRepositoryImpl implements ExtPersonRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public Person validAndSave(Person entity) {
        entityManager.persist(entity);
        return entity;
    }
}
