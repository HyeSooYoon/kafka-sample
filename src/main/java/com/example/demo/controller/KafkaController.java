package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.producer.KafkaProducer;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/kafka")
@Slf4j
public class KafkaController {

    private final KafkaProducer producer;

    @Autowired
    KafkaController(KafkaProducer producer){
        this.producer = producer;
    }


    @PostMapping
    @ResponseBody
    public String sendMessage(@RequestParam(value="message") String message) {
        log.info("message : {}", message);
        this.producer.sendMessage(message);

        return "success";
    }
}