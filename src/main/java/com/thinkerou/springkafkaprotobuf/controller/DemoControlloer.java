package com.thinkerou.springkafkaprotobuf.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkerou.springkafkaprotobuf.service.DemoService;

@RestController
@RequestMapping("/rest/n/spring/kafka/protobuf")
public class DemoControlloer {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/demo")
    public Object demo() {
        Map<String, Object> result = demoService.run();
        return result;
    }
}
