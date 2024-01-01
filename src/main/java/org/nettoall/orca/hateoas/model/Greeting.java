package org.nettoall.orca.hateoas.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

/**
 * RepresentationModel 구현 - 표시된대로 렌더링이 보장됨
 */
public class Greeting extends RepresentationModel<Greeting> {
    private final String content;

    // @JsonCreator Signals ow jackson can crate an instance of this POJO
    // @JsonProperty Marks the field into which Jackson should put this constructor argument
    @JsonCreator
    public Greeting(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
