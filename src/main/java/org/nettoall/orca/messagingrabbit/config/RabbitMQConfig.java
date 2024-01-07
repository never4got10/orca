package org.nettoall.orca.messagingrabbit.config;

import org.nettoall.orca.messagingrabbit.receiver.RabbitReceiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;


/**
 * RabbitMQ와 통신하기 위해서
 * 1. Queue, TopicExchange 정의
 * 2. Queue 와 TopicExchange binding 설정
 * 3. ListenerContainer 설정
 * 4. POJO Receiver 클래스를 Wrapping 하는 ListenerAdapter 설정
 */
//@Configuration
public class RabbitMQConfig {

    private static final String topicExchangeName = "spring-boot-exchange";

    private static final String queueName = "spring-boot";

    @Bean
    public Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foor.bat.#");
    }

    @Bean
    public SimpleMessageListenerContainer rabbitContainer(ConnectionFactory connectionFactory,
                                                          MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    public MessageListenerAdapter rabbitListenerAdapter(RabbitReceiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
}
