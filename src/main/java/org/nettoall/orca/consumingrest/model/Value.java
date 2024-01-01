package org.nettoall.orca.consumingrest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Quote에서 참조하는 내부 변수 클래스
 *
 * @param id
 * @param quote
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Value(Long id, String quote) {
}
