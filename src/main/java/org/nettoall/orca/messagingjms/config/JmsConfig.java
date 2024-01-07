package org.nettoall.orca.messagingjms.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import jakarta.jms.ConnectionFactory;

/**
 * SpringApplication 에 @EnableJms 정의 필요
 */
//@Configuration
public class JmsConfig {

    /**
     * dependency의 library에 ConnectionFactory가 여러 개 있어서 한정자 @Qualifier 로 사용할 클래스 지정
     * @param connectionFactory
     * @param configurer
     * @return
     */
    @Bean
    public JmsListenerContainerFactory<?> myFactory(@Qualifier("jmsConnectionFactory") ConnectionFactory connectionFactory,
                                                    DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        // This provides all auto-configured defaults to this factory. including the message converter
        configurer.configure(factory, connectionFactory);
        // You could still override som settings if necessary
        return factory;
    }

    /**
     * Configurer에 의해 ListenerContainerFactory와 ConnectionFactory가 설정될 때 자동으로 포함됨
     *
     * @return
     */
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
