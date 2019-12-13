package com.iot.container.client;

public interface ITopicHandler<T,R>
{
    R handle(T t) throws Exception;
}
