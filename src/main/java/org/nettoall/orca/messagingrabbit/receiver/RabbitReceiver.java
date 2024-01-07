package org.nettoall.orca.messagingrabbit.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class RabbitReceiver {

    private static final Logger logger = LoggerFactory.getLogger(RabbitReceiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    /**
     * message receive 시 호출할 메소드 정의
     *
     * @param message
     */
    public void receiveMessage(String message) {
        logger.info("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
