package com.example.demo.service.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.model.Address;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public void register(UserDto user) {
        System.out.println("This is a test");
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
       // newUser.setId(UUID.randomUUID().toString());
        newUser.setUserRegistrationDate(LocalDateTime.now());

        Address address = new Address();
        address.setId(UUID.randomUUID().toString());
        address.setCity("Bagmati");
        address.setCountry("Nepal");
        address.setStreet("Street");
        address.setDistrict("Kathmandu");

        newUser.setAddress(address);
       userRepository.save(newUser);
    }

}
