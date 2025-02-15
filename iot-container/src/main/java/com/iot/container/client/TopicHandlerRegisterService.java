package com.iot.container.client;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;


public class TopicHandlerRegisterService extends ClassPathBeanDefinitionScanner
{
    
    public TopicHandlerRegisterService(BeanDefinitionRegistry registry, boolean useDefaultFilters)
    {
        super(registry, useDefaultFilters);
    }
    
    
    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        //添加过滤条件
        addIncludeFilter(new AnnotationTypeFilter(TopicHandler.class));
        //调用spring的扫描
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
        if(beanDefinitionHolders.size() != 0){
            //给扫描出来的接口添加上代理对象
            processBeanDefinitions(beanDefinitionHolders);
        }
        return beanDefinitionHolders;
    }
    
    
    /**
     * 给扫描出来的接口添加上代理对象
     * @param beanDefinitions
     */
    private void processBeanDefinitions(Set<BeanDefinitionHolder> beanDefinitions) {
        GenericBeanDefinition definition;
        for (BeanDefinitionHolder holder : beanDefinitions) {
            definition = (GenericBeanDefinition) holder.getBeanDefinition();
            //设置属性 即所对应的消费接口
            try {
                //拿到接口的全路径名称
                String beanClassName = definition.getBeanClassName();
                //把接口的全路径放入ProxyFactoryBean 的构造器中,在构造器中会自动转成 class类型
                definition.getConstructorArgumentValues().addGenericArgumentValue(beanClassName);
                //definition.get
                definition.setBeanClass(ProxyFactoryBean.class);
                //按 照查找Bean的Class的类型
                definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
                
                
                //super.registry.registerBeanDefinition();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return  beanDefinition.getMetadata().isIndependent();
    }
    
}

