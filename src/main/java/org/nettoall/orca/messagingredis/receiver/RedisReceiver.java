package org.nettoall.orca.messagingredis.receiver;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedisReceiver {

    private static final Logger logger = LoggerFactory.getLogger(RedisReceiver.class);

    private AtomicInteger counter = new AtomicInteger();

    /**
     * 메시지를 수신했을 때 처리할 내용을 receiveMessage() 에 정의
     *
     * @param message
     */
    public void receiveMessage(String message) {
        logger.info("Receiver <" + message + ">");
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }
}
