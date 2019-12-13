package com.iot.container.client;

import java.lang.annotation.*;

/**
 * 扫描topic handler 注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TopicHandler
{
    String topic() default "";
    
    /**
     * 默认使用JSON序列化
     * @return
     */
    MqttPayloadDecodeMethod decodeMethod() default MqttPayloadDecodeMethod.JSON;
}
