package com.sample.controller;

import com.sample.audit.Audit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Audit(value = "Sayhello")
    @PostMapping("/sayHello")
    String sayHello(@RequestBody String name) {
        log.info("This is a hello to" + name);
        return ("I have said hello to "  + name);
    }

    @Audit(value = "sayHelloWithException")
    @PostMapping("/sayHelloWithException")
    void sayHelloWithException(@RequestBody String name) throws Exception {
        log.error("Unable to Say hello to" + name);
        throw new Exception("Unable to Say hello to" + name);
    }
}
