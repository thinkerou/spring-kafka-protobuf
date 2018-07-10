package com.thinkerou.springkafkaprotobuf.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.thinkerou.proto.helloworld.Callback;

@Component
public class Sender {

    @Autowired
    private KafkaTemplate<Long, Callback> kafkaTemplate;

    public void send(Callback request) {
        kafkaTemplate.send("spring-kafka-protobuf-demo", request);
    }
}
