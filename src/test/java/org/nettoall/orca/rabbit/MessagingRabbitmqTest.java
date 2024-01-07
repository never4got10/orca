package org.nettoall.orca.rabbit;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.nettoall.orca.messagingrabbit.receiver.RabbitReceiver;
import org.nettoall.orca.messagingrabbit.runner.RabbitRunner;
import org.springframework.amqp.AmqpConnectException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class MessagingRabbitmqTest {

    @MockBean
    private RabbitRunner runner;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitReceiver receiver;

    @Test
    public void test() throws Exception {
        try{
            rabbitTemplate.convertAndSend("spring-boot", "Hello From RabbitMQ!");
            receiver.getLatch().await(10000, TimeUnit.MICROSECONDS);
        } catch (AmqpConnectException e) {

        }
    }
}
