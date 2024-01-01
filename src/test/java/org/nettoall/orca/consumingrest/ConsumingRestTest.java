package org.nettoall.orca.consumingrest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.nettoall.orca.consumingrest.model.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class ConsumingRestTest {
    private final static Logger log = LoggerFactory.getLogger(ConsumingRestTest.class);

    RestTemplate restTemplate;

    @BeforeEach
    public void init(){
        restTemplate = new RestTemplate();
    }

    /**
     * Consumming rest sample
     *
     */
    @Test
    public void ConsummingRest() {
        // 원하는 데이터를 포함한 domain class 로 반환
        Quote quote = restTemplate.getForObject("http://localhost:8081/api/random", Quote.class);

        log.info("quote string : " + quote.toString());
    }
}
