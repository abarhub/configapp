package org.configapp.rest;


import java.util.concurrent.atomic.AtomicLong;

import org.configapp.dto.Greeting;
import org.configapp.dto.InitResponseDTO;
import org.configapp.dto.InitDTO;
import org.configapp.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

//g.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.configapp.service.ConfigApp;

@RestController
public class Rest1 {

    private static Logger logger = LoggerFactory.getLogger(Rest1.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private ConfigApp configApp;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }


    @RequestMapping(value = "/api/v1/init",consumes = MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.POST)
    public ResponseEntity<InitResponseDTO> init(@RequestBody InitDTO init) {

        logger.info("Hello World "+init.getName());

        String id=configApp.createApp(init);

        InitResponseDTO initResponseDTO=new InitResponseDTO();
        initResponseDTO.setIdApp(id);

        return new ResponseEntity<InitResponseDTO>(initResponseDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/v1/{idApp}",consumes = MediaType.APPLICATION_JSON_VALUE, method= RequestMethod.POST)
    public ResponseEntity<String> setConfig(
            @PathVariable String idApp,
            @RequestBody ConfigDTO configDTO) {

        logger.info("config "+idApp);
        configApp.config(idApp,configDTO);

        return new ResponseEntity<String>("",HttpStatus.OK);
    }

}