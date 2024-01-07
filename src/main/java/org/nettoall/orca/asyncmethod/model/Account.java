package org.nettoall.orca.asyncmethod.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @JsonIgnoreProperties class 에 정의된 attribute 가 아닌 경우 무시하라는 의미
 *
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
    private String name;
    private String blog;
}
