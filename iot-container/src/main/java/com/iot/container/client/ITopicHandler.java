package com.iot.container.client;

public interface ITopicHandler<T>
{
    T decode(byte[] data);
    
    byte[]  handle(T t) throws Exception;
}
