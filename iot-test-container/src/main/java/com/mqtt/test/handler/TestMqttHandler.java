package com.mqtt.test.handler;

import com.iot.container.client.ITopicHandler;
import com.iot.container.client.MqttPayloadDecodeMethod;
import com.iot.container.client.TopicHandler;
import com.mqtt.test.Message;
import org.springframework.stereotype.Component;

@TopicHandler(topic = "test")
public class TestMqttHandler implements ITopicHandler<byte[]>
{
    
    @Override
    public byte[] decode(byte[] data)
    {
        return data;
    }
    
    @Override
    public byte[]  handle(byte[] data)throws Exception
    {
        Message.register register =  Message.register.parseFrom(data);
        System.out.println(register.toString());
        
        return null;
    }
}
