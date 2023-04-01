package com.olbnar.olddatabaseprocessor.controllers;

import com.olbnar.olddatabaseprocessor.service.OldUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/old-users")
public class OldUserController {
    @Autowired
    private OldUserService oldUserService;

    @GetMapping
    public void userProcessor() {
        oldUserService.processOldUsers();
    }


}
