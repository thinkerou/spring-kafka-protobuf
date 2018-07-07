package com.thinkerou.springkafkaprotobuf.kafka;

import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.InvalidProtocolBufferException;
import com.thinkerou.proto.helloworld.Callback;

public class CallbackDeserializer  extends Adapter implements Deserializer<Callback> {

    private static final Logger logger = LoggerFactory.getLogger(CallbackDeserializer.class);

    @Override
    public Callback deserialize(final String topic, byte[] data) {
        try {
            return Callback.parseFrom(data);
        } catch (InvalidProtocolBufferException e) {
            logger.error("Received un-parse message: ", e);
            throw new RuntimeException("Received un-parse message " + e.getMessage(), e);
        }
    }
}
