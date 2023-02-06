package com.forgeeks.SpringDZ5.core.configs;

import com.fasterxml.jackson.databind.ser.std.NumberSerializers;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.ByteBuffer;

public class LongSerializer implements RedisSerializer<Long> {
//    @Override
//    public byte[] serialize(Long aLong) throws SerializationException {
//        return new byte[0];
//    }
//
//    @Override
//    public Long deserialize(byte[] bytes) throws SerializationException {
//        return null;
//    }

    @Override
    public byte[] serialize(Long aLong) throws SerializationException {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(aLong);
        return buffer.array();
    }

    @Override
    public Long deserialize(byte[] bytes) throws SerializationException {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.put(bytes);
        buffer.flip();
        return buffer.getLong();
    }
}