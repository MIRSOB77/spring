package org.mimo.rest;

import org.mimo.repository.entity.Person;
import org.mimo.service.UserManagementService;
import org.mimo.service.exception.UserManagementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Mirsad on 23.02.2015.
 */
@RestController("/person")
public class UserManagementRestController {
    @Autowired
    UserManagementService userManagementService;

    @RequestMapping(value = "/register", method = RequestMethod.POST )
    @ResponseStatus(HttpStatus.OK)
    public void registerUser(@RequestBody Person userdata){
        userManagementService.registerUser(userdata);
    }

    @RequestMapping("/person/{nickname}")
    @ResponseStatus(HttpStatus.OK)
    public void nicknameExists(@PathVariable("nickname") String nickname){
        userManagementService.userNicknameExists(nickname);
    }

    @ExceptionHandler(value = { UserManagementException.class })
    public void handleException(Errors errors){

    }

}
