package org.nettoall.orca.messagingjms.runner;

import org.nettoall.orca.messagingjms.entity.Email;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;

/**
 * SpringApplication 구동시 실행됨
 */
//@Component
public class JmsRunner implements CommandLineRunner {
    private final JmsTemplate jmsTemplate;

    public JmsRunner(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending an Email Message...");
        jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
    }
}
