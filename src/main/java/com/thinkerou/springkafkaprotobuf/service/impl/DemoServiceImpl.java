package com.thinkerou.springkafkaprotobuf.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.thinkerou.proto.helloworld.Callback;
import com.thinkerou.proto.helloworld.KafkaEventOne;
import com.thinkerou.proto.helloworld.KafkaEventTwo;
import com.thinkerou.springkafkaprotobuf.SpringKafkaProtobufApplication;
import com.thinkerou.springkafkaprotobuf.kafka.Sender;
import com.thinkerou.springkafkaprotobuf.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

    public Map<String, Object> run() {
        Map<String, Object> result = new HashMap<>();

        Callback request = Callback.newBuilder()
                .setOneEvent(KafkaEventOne.newBuilder().setAddress("beijing").build())
                .setTwoEvent(KafkaEventTwo.newBuilder().setNumber(123456).build())
                .build();

        Sender sender = SpringKafkaProtobufApplication.context.getBean(Sender.class);
        sender.send(request);

        return result;
    }
}
