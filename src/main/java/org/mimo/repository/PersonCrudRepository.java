package org.mimo.repository;

import org.mimo.repository.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mirsad on 22.02.2015.
 */
public interface PersonCrudRepository extends JpaRepository<Person, Long>,ExtPersonRepository {

}
