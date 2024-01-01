package org.nettoall.orca.restful.service;

/**
 * Resource Representation class
 * id와 content에 대한 record class
 * jackson JSON library를 사용 GreetingRestful 을 JSON 으로 자동 마샬링
 *
 * @param id
 * @param content
 */
public record GreetingRestful(long id, String content) {
    
}
