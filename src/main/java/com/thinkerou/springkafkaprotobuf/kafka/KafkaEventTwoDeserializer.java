package com.thinkerou.springkafkaprotobuf.kafka;

import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.InvalidProtocolBufferException;
import com.thinkerou.proto.helloworld.KafkaEventTwo;

public class KafkaEventTwoDeserializer extends Adapter implements Deserializer<KafkaEventTwo> {

    private static final Logger logger = LoggerFactory.getLogger(KafkaEventTwoDeserializer.class);

    @Override
    public KafkaEventTwo deserialize(final String topic, byte[] data) {
        try {
            return KafkaEventTwo.parseFrom(data);
        } catch (InvalidProtocolBufferException e) {
            logger.error("Received un-parse message: ", e);
            throw new RuntimeException("Received un-parse message " + e.getMessage(), e);
        }
    }
}
