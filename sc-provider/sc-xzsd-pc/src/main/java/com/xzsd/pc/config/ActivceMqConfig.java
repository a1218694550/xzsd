package com.xzsd.pc.config;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.*;
import java.util.ArrayList;
import java.util.List;


/**
 * ActivceMq配置类
 */

@Configuration
public class ActivceMqConfig {
//    @Value("${spring.activemq.broker-url}")
//    private String brokerUrl;
//
//    @Value("${spring.activemq.user}")
//    private String username;
//
//    @Value("${spring.activemq.password}")
//    private String password;
//
//    @Value("${spring.jms.queue-name}")
//    private String queueName;
//
//    @Value("${spring.jms.topic-name}")
//    private String topicName;
//
//    @Bean(name = "queue")
//    public Queue queue() {
//        return new ActiveMQQueue(queueName);
//    }
//
//    @Bean(name = "topic")
//    public Topic topic() {
//        return new ActiveMQTopic(topicName);
//    }
//
//    /**
//     * 生产者
//     * @return
//     */
//
//    @Bean
//    public ConnectionFactory connectionFactory(){
//        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(username, password, brokerUrl);
////        activeMQConnectionFactory.setTrustAllPackages(true); //设置信任所有包
//        //设置信号特定的一个或多个包
//        List<String> list = new ArrayList<>();
//        //这里可以添加要信任的实体类所在包的路径
//        list.add("com.neusoft.sprintboot.goods.entity");
//        activeMQConnectionFactory.setTrustedPackages(list);
//        return activeMQConnectionFactory;
//    }
//    @Bean
//    public JmsMessagingTemplate jmsMessageTemplate(){
//        return new JmsMessagingTemplate(connectionFactory());
//    }
//
//
//    /**
//     * 消费者
//     * @param connectionFactory
//     * @return
//     */
//    // 在Queue模式中，对消息的监听需要对containerFactory进行配置
//    @Bean("queueListener")
//    public JmsListenerContainerFactory<?> queueJmsListenerContainerFactory(ConnectionFactory connectionFactory){
//        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setPubSubDomain(false);
//        return factory;
//    }
//
//    //在Topic模式中，对消息的监听需要对containerFactory进行配置
//    @Bean("topicListener")
//    public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory(ConnectionFactory connectionFactory){
//        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setPubSubDomain(true);
//        return factory;
//    }
}

