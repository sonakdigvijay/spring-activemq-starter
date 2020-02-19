package com.learning.controller;

import com.learning.service.SpringActiveMqMessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/activemq")
public class SpringActiveMqProducerController {

    @Autowired
    private SpringActiveMqMessageProducerService service;

    @RequestMapping(value = "/marco")
    public String polo() {
        return "polo";
    }

    @RequestMapping(value = "/sendit")
    public ResponseEntity<String> publishMessageToActiveMq(@RequestParam(name = "message")String message) {
        System.out.println(message);
        service.publish(message);
        return new ResponseEntity<String>("Complete", HttpStatus.OK);
    }
}
