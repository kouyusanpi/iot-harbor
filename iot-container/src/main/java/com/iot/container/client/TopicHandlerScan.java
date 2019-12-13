package com.iot.container.client;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
//spring中的注解,加载对应的类
@Import(TopicHandlerFindScan.class)
@Documented
public @interface TopicHandlerScan
{
    String[] basePackage() default {};
}
