package com.thinkerou.springkafkaprotobuf.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.thinkerou.proto.helloworld.HelloRequest;
import com.thinkerou.springkafkaprotobuf.SpringKafkaProtobufApplication;
import com.thinkerou.springkafkaprotobuf.kafka.Sender;
import com.thinkerou.springkafkaprotobuf.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

    public Map<String, Object> run() {
        Map<String, Object> result = new HashMap<>();

        HelloRequest request = HelloRequest.newBuilder()
                .setName("thinkerou")
                .build();

        Sender sender = SpringKafkaProtobufApplication.context.getBean(Sender.class);
        sender.send(request);

        return result;
    }
}
