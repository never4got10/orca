package org.nettoall.orca.consumingrest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 사용할 데이터를 포함하는 domain 클래스 정의
 * @JsonIgnoreProperties  이 유형에 바인딩되지 않는 모든 속성 무시 (?)
 * 데이터를 사용자 유형 타입에 직접 바인딩하려면 API로부터 바환되는 JSON 도쿠멘트
 * 의 key와 동일한 변수 이름으로 정의해야 함. 일치하지 않으면 @JsonProperty 사용하여
 * 매칭시켜줌
 *
 * @param type
 * @param vlaue
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Quote(String type, Value vlaue) {
}
