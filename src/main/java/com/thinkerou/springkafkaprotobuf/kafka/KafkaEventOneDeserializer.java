package com.thinkerou.springkafkaprotobuf.kafka;

import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.InvalidProtocolBufferException;
import com.thinkerou.proto.helloworld.KafkaEventOne;

public class KafkaEventOneDeserializer extends Adapter implements Deserializer<KafkaEventOne> {

    private static final Logger logger = LoggerFactory.getLogger(KafkaEventOneDeserializer.class);

    @Override
    public KafkaEventOne deserialize(final String topic, byte[] data) {
        try {
            return KafkaEventOne.parseFrom(data);
        } catch (InvalidProtocolBufferException e) {
            logger.error("Received un-parse message: ", e);
            throw new RuntimeException("Received un-parse message " + e.getMessage(), e);
        }
    }
}
