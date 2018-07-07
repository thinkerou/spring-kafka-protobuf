package com.thinkerou.springkafkaprotobuf.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.thinkerou.proto.helloworld.HelloRequest;

@Component
public class Sender {

    @Autowired
    private KafkaTemplate<Long, HelloRequest> kafkaTemplate;

    public void send(HelloRequest request) {
        kafkaTemplate.send("spring-kafka-protobuf-demo", request);
    }
}
