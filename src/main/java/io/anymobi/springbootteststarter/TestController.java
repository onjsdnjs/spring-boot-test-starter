package io.anymobi.springbootteststarter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestService.class);

    @Autowired
    TestService testService;

    @GetMapping("/hello")
    public String test(){
        logger.debug("onjsdnjs");
        return "hello " + testService.getName();
    }

    @GetMapping("/users")
    public User createUser(@RequestBody User user) {

        return user;
    }

}
