package com.tmarszelewski.emailsender.controller;

import com.tmarszelewski.emailsender.resource.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactControllerTest {

    @Autowired
    ContactController contactController;

    @Test
    void shouldGetRightSizeOfList() {
        assertEquals(contactController.getAllContacts().size(), 7);
    }

    @Test
    void shouldFindRightContact() {
        ResponseEntity responseEntity = contactController.getContactById(3);
        Assertions.assertTrue(new Contact(3, "test_name_3", "user_3_@test.com").equals(responseEntity.getBody()));
    }

    @Test
    void shouldReturnNotFoundStatus() {
        ResponseEntity responseEntity = contactController.getContactById(8);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test
    void shouldUpdateExistingContact() {
        Contact updatedContact = contactController.updateContact(new Contact(5, "test_name_5_updated", "user_5_updated_@test.com"));
        assertTrue(contactController.getContactById(5).getBody().equals(new Contact(5,"test_name_5_updated", "user_5_updated_@test.com")));
    }

    @Test
    void shouldDeleteContactWithGivenId() {
        assertEquals(contactController.deleteContact(6), new Contact(6,"test_name_6", "user_6_@test.com"));
        assertEquals(contactController.getContactById(6).getStatusCode(), HttpStatus.NOT_FOUND);
    }
}