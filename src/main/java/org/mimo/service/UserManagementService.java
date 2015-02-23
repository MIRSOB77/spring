package org.mimo.service;

import org.apache.commons.lang.time.DateUtils;
import org.jvnet.hk2.annotations.Service;
import org.mimo.repository.PersonCrudRepository;
import org.mimo.repository.PersonRepository;
import org.mimo.repository.PersonRepository;
import org.mimo.repository.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.util.Assert;
import org.springframework.validation.ValidationUtils;

import java.time.DateTimeException;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Mirsad on 22.02.2015.
 */
@Service
@Scope("session")
public class UserManagementService {
    @Autowired
    PersonRepository personSearchRepository;

    @Autowired
    PersonCrudRepository personStoreRepository;

    @Value("${myproject.sso.token}")
    String ssoToken;

    public Person registerUser(Person person){
        Assert.notNull(person);

        Date eighteenYearsBefore = new Date();
        eighteenYearsBefore = DateUtils.addYears(eighteenYearsBefore, 18);

        if(!person.getBirth().before(eighteenYearsBefore)) {
            throw new DateTimeException("User must be at least 18 years old");
        }
        person = personStoreRepository.save(person);
        return person;
    }

    public Boolean userNicknameExists(String nickname){
        Assert.hasText(nickname);
        return (personSearchRepository.findByNickname(nickname) != null);
    }


    public String logonUser(String username, String password){
        Assert.hasText(username,"Username missing");
        Assert.hasText(password,"Password missing");

        Person loggedPerson = personSearchRepository.findByNicknameAndPassword(username, password);
        loggedPerson.setOnline(true);
        loggedPerson.setSsoToken(loggedPerson.getId() + ssoToken);
        personStoreRepository.save(loggedPerson);
        return ssoToken;
    }



}
