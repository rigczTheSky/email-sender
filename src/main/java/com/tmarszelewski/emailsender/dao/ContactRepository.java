package com.tmarszelewski.emailsender.dao;

import com.tmarszelewski.emailsender.resource.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
