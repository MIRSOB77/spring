package org.mimo.service;

import org.jvnet.hk2.annotations.Service;
import org.mimo.repository.PersonCrudRepository;
import org.mimo.repository.PersonRepository;
import org.mimo.repository.entity.ChatMessage;
import org.mimo.repository.entity.Person;
import org.mimo.utils.RawMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * Created by Mirsad on 22.02.2015.
 */
@Service
@Scope("session")
public class MessageService {
    @Autowired
    PersonRepository personRepository;

    public void send(RawMessage message){
        Person receiver = personRepository.findByNickname(message.getReceiver());
        if(receiver.getOnline()){

        }

    }
}
