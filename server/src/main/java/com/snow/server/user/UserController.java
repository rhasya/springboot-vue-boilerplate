package com.snow.server.user;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/check")
    public Map<String, Object> check(@AuthenticationPrincipal User user) {
        Map<String, Object> r = new HashMap<>();
        if (user == null) {
            log.debug("user is null");
            r.put("ok", "0");
            return r;
        }
        log.debug(user.toString());
        r.put("ok", "1");
        return r;
    }
}
