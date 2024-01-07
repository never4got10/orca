package org.nettoall.orca.messagingrabbit.runner;

import java.util.concurrent.TimeUnit;

import org.nettoall.orca.messagingrabbit.receiver.RabbitReceiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;

/**
 * 구동 시점에 실행해야 할 코드가 있을 경우 정의
 * 1. @Component 선언
 * 2. run() 메소드에 실행할 코드 정의
 *
 * 유사한 기느엥 ApplicationRunner가 있음
 * String 대신 ApplicationArguments를 인자로 받음
 *
 * 여러 개의 Runner가 있을 경우 @Order 로 수선 정의
 * @Component만 주석 처리하면 비활성화됨
 */
//@Component
public class RabbitRunner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitReceiver receiver;

    public RabbitRunner(RabbitReceiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending Message.....");
        rabbitTemplate.convertAndSend("spring-boot-exchange", "foo.bat.baz","Hello from RabbitMQ!");
        receiver.getLatch().await(10000, TimeUnit.MICROSECONDS);
    }
}
