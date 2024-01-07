package org.nettoall.orca.redis.send;

import org.junit.jupiter.api.Test;
import org.nettoall.orca.messagingredis.receiver.RedisReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class RedisSendTest {

    private static final Logger logger = LoggerFactory.getLogger(RedisSendTest.class);

    @Autowired
    ApplicationContext ctx;

    @Test
    public void messageSend() throws InterruptedException {
        StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
        RedisReceiver receiver = ctx.getBean(RedisReceiver.class);

        while(receiver.getCount() == 0) {
            logger.info("Sending Message....");
            template.convertAndSend("chat","Hello from Redis!");
            Thread.sleep(500L);
        }
    }
}
