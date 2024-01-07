package org.nettoall.orca.restful.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.nettoall.orca.restful.service.GreetingRest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Building a RESTful Web Service
 * <p>
 * 참고 @RestController 가 @Controller 와 @ResponseBody를 모두 포함하는 약어?
 */
@RestController
public class GreetingRestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
     * GreetingRestful class 반환
     * MVC 와의 차이는 본문이 생성되는 방식 - MVC는 view 기술에 의존하는데 비해
     * rest는 record를 채우고 반환 : 객체 데이터는 HTTP respnse를 JSON 으로 직접 작성
     * Jackson2 의 MappingJackson2HttpMessggeConverter가 자동으로 GreetingRest을
     * JSON 으로 변환
     *
     * @param name request로 접수한 param
     * @return GreetingRestful representation
     */
    @GetMapping("/hellorest")
    public GreetingRest greeting(@RequestParam(value="name", defaultValue = "World") String name) {
        return new GreetingRest(counter.incrementAndGet(), String.format(template, name) );
    }
}
