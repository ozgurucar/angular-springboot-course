package com.ozgurucr.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    @Autowired
    public MyFirstService(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    private final MyFirstClass myFirstClass;

    public String tellAStory() {
        return "The dependency is saying : " + myFirstClass.sayHello();
    }
}
