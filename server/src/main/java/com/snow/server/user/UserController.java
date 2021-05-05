package com.snow.server.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @PostMapping("")
    public void check(@RequestBody Map<String, String> body) {
        log.debug(body.toString());
        log.debug("Success");
    }
}
