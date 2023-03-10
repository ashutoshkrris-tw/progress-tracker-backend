package com.ashutoshkrris.projects.progresstracker.controller;

import com.ashutoshkrris.projects.extras.basic.auth.progresstracker.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthenticationController {

    @GetMapping("/basicauth")
    public AuthenticationBean basicAuthController() {
        return new AuthenticationBean("You are authenticated");
    }

}
