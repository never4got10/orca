package org.nettoall.orca.messagingjms.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Email {
    private String to;
    private String body;
}
