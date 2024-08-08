package com.ozgurucr.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:test.properties")
public class MyFirstService {


    @Autowired
    public MyFirstService(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    private final MyFirstClass myFirstClass;

    public String getCustomProperty() {
        return customProperty;
    }

    @Value("${my.custom.property}")
    private String customProperty;

    public String tellAStory() {
        return "The dependency is saying : " + myFirstClass.sayHello();
    }

    public String getJavaVersion() {
        return System.getProperty("java.version");
    }

    public String getDeviceName() {
        return System.getProperty("os.name");
    }
}
