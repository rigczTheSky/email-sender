package com.tmarszelewski.emailsender.resource;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailMessage {

    private String to;
    private String from;
    private String subject;
    private String message;

}
