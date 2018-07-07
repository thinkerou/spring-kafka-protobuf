package com.thinkerou.springkafkaprotobuf.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.thinkerou.proto.helloworld.Callback;

@Component
public class Receiver {

    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    @KafkaListener(topics = {"spring-kafka-protobuf-demo"})
    public void listen(ConsumerRecord<?, Callback> record) {
        Callback callback = record.value();
        logger.warn("message: {}", callback);
        switch (callback.getEventTypeCase()) {
            case ONE_EVENT:
                logger.warn("one event: {}", callback.getOneEvent());
                break;
            case TWO_EVENT:
                logger.warn("two event: {}", callback.getOneEvent());
                break;
            default:
                logger.warn("default value...");
                break;
        }
    }
}
