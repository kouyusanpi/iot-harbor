package com.iot.container;

import com.iot.container.client.ITopicHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.util.Arrays;

@Slf4j
public class ClientMessageAcceptor implements MessageAcceptor
{
    
    @Resource
    private ApplicationContext applicationContext;
    
    @Resource
    private IotConfig iotConfig;
    
    @Override
    public void accept(String topic, byte[] message)
    {
        if(log.isDebugEnabled())
        {
            log.debug("topic={},message={}",topic, Arrays.toString(message));
        }
        String[] topicArray = topic.split("/");
        Object  bean = applicationContext.getBean(topicArray[0]);
        if(bean != null && bean instanceof ITopicHandler)
        {
            ITopicHandler handler = (ITopicHandler)bean;
            try
            {
                Object result = handler.handle(message);
                
            }
            catch (Exception e)
            {
                log.warn("bean handling was error",e);
            }
        }
        else
        {
            log.warn("has no found topic handler by name={}",topic);
        }
    }
}
