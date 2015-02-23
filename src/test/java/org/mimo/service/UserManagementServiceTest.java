package org.mimo.service;

import junit.framework.TestCase;
import org.aspectj.lang.annotation.Before;
import org.junit.runner.RunWith;
import org.mimo.DemoApplication;
import org.mimo.repository.PersonCrudRepository;
import org.mimo.repository.entity.Person;
import org.mimo.utils.ChatRole;
import org.mimo.utils.Gender;
import org.mockito.Mock;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.ParseException;
import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class UserManagementServiceTest extends TestCase {
    @Mock
    private PersonCrudRepository personCrudRepository;

    @org.junit.Before
    protected void setup(){
        try {
            Person joe = new Person("joe", "john", "miller", "joe@gmail.com", Gender.MAlE, ChatRole.COMMON, "01.10.1992" );
            Person susan = new Person("susan", "susyOne","brown","brown@gmail.com", Gender.FEMALE, ChatRole.COMMON, "01.10.1993" );

            personCrudRepository.save(Arrays.asList(joe,susan));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void testRegisterUserShouldFailWithNicknameRequired() throws Exception {
        try {
            personCrudRepository.deleteAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @org.junit.After
    public void destroy(){

    }

}