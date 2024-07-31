package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.dto.UserRegistrationResponse;
import com.example.demo.service.UserRegistrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserRegistrationController {

    public UserRegistrationService userRegistrationService;

    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping(value = "/user/registration")
    @ResponseBody
    public UserRegistrationResponse registerUser(@RequestBody UserDto user) {
        userRegistrationService.register(user);
        UserRegistrationResponse response = new UserRegistrationResponse();
        response.setUserEmail(user.getEmail());
        response.setUserName(user.getUsername());
        response.setMessage("User Successfully Registered!");
        return response;
    }

}
