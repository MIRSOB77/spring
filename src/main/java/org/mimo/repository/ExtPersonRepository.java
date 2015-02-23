package org.mimo.repository;

import org.mimo.repository.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Mirsad on 22.02.2015.
 */
@Repository
public interface ExtPersonRepository {
   public Person validAndSave(Person entity);
}
