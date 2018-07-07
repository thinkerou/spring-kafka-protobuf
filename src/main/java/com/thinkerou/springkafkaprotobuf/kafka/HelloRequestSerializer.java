package com.thinkerou.springkafkaprotobuf.kafka;

import org.apache.kafka.common.serialization.Serializer;

import com.thinkerou.proto.helloworld.HelloRequest;

public class HelloRequestSerializer extends Adapter implements Serializer<HelloRequest> {

    @Override
    public byte[] serialize(final String topic, final HelloRequest data) {
        return data.toByteArray();
    }
}
