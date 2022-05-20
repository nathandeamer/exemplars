package com.nathandeamer.exemplars;

import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloWorldController {

    private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    private final Random random = new Random();

    @GetMapping
    @Timed(value = "hello_world_timer", histogram = true)
    public ResponseEntity<String> helloWorld() throws Exception {
        log.info("Hello world!");
        int n = random.nextInt(499) + 1;
        Thread.sleep(n);
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
}
