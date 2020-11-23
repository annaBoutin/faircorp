package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class DummyUserService implements UserService {

    private GreetingService greetingService;

    @Autowired
    public DummyUserService(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    @Override
    public void greetAll() {
        List<String> noms = Arrays.asList("Elodie","Charles");
        greetingService.greet(noms.get(0));
        greetingService.greet(noms.get(1));
    }
}
