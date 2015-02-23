package org.mimo.rest;

import org.mimo.repository.entity.ChatMessage;
import org.mimo.repository.entity.Person;
import org.mimo.service.MessageService;
import org.mimo.service.UserManagementService;
import org.mimo.utils.ChatRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Mirsad on 22.02.2015.
 */
@RestController("/message")
public class ChatRestController {

    @Autowired
    MessageService messageService;

    @RequestMapping(value = "/send/{receiver}", method = RequestMethod.POST )
    public ResponseEntity<Boolean> sendMessage(@PathVariable String receiverNickname, @RequestBody ChatMessage userdata){
       // messageService.send(userdata);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");
        return new ResponseEntity<Boolean>(Boolean.TRUE, responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/read/{ssoToken}", method = RequestMethod.POST )
    public String registerUser(@RequestBody Person userdata){
        return "";
    }
}
