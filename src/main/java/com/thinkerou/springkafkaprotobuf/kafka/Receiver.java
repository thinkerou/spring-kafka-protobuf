package com.thinkerou.springkafkaprotobuf.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    @KafkaListener(topics = {"spring-kafka-protobuf-demo"})
    public void listen(ConsumerRecord<?, ?> record) {
        logger.warn("message: {}", record.value());
    }
}
