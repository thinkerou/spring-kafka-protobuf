package com.thinkerou.springkafkaprotobuf.kafka;

import org.apache.kafka.common.serialization.Serializer;

import com.thinkerou.proto.helloworld.Callback;

public class CallbackSerializer extends Adapter implements Serializer<Callback> {

    @Override
    public byte[] serialize(final String topic, final Callback data) {
        return data.toByteArray();
    }
}
