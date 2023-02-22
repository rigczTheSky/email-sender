package com.tmarszelewski.emailsender.resource;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contacts")
public class Contact {

    public Contact(String name, String email){
        this.name = name;
        this.email = email;
    }
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "email address is required")
    private String email;
}
