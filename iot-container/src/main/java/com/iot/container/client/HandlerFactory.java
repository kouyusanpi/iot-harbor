package com.iot.container.client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HandlerFactory
{
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap(256);
    
    public void putHanlder(String topic,Object handler)
    {
        singletonObjects.put(topic,handler);
    }
    
    public Object getHanlder(String topic)
    {
        return singletonObjects.get(topic);
    }
}
