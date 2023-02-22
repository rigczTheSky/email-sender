package com.tmarszelewski.emailsender.controller;

import com.tmarszelewski.emailsender.dao.ContactRepository;
import com.tmarszelewski.emailsender.resource.EmailMessage;
import com.tmarszelewski.emailsender.resource.Contact;
import com.tmarszelewski.emailsender.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmailController {
    private final EmailSenderService emailSenderService;

    @Autowired
    private final ContactRepository contactRepository;

    public EmailController(EmailSenderService emailSenderService, ContactRepository contactRepository) {
        this.emailSenderService = emailSenderService;
        this.contactRepository = contactRepository;
    }

    @PostMapping("/send-email")
    public ResponseEntity sendEmail(@RequestBody EmailMessage emailMessage) {
        this.emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/send-to-all")
    public ResponseEntity sendToAll(@RequestBody EmailMessage emailMessage) {
        List<Contact> contactList = contactRepository.findAll();
        for (Contact contact : contactList) {
            this.emailSenderService.sendEmail(contact.getEmail(), emailMessage.getSubject(), emailMessage.getMessage());
        }
        return ResponseEntity.ok("Success");
    }
}
