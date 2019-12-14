package com.mqtt.test;

import com.iot.container.client.TopicHandlerScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.springframework.boot.SpringApplication.run;
@SpringBootApplication
@TopicHandlerScan(basePackage = "com.mqtt.test")
public class ServerContainer {

    public static void main(String[] args)
    {
        ConfigurableApplicationContext run = run(ServerContainer.class, args);
    }

}
