package com.mqtt.test.handler;

import com.iot.container.client.ITopicHandler;
import com.iot.container.client.MqttPayloadDecodeMethod;
import com.iot.container.client.TopicHandler;
import com.mqtt.test.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@TopicHandler(topic = "test")
public class TestMqttHandler implements ITopicHandler<byte[]>
{
    
    @Resource
    private ApplicationContext applicationContext;
    
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
