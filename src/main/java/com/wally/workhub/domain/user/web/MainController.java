package com.wally.workhub.domain.user.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String home() {
        return "Welcome to WorkHub";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Welcome Admin";
    }

    @GetMapping("/user")
    public String user() {
        return "Welcome User";
    }
}
