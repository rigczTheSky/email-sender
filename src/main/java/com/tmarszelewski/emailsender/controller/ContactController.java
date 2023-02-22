package com.tmarszelewski.emailsender.controller;

import com.tmarszelewski.emailsender.resource.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.tmarszelewski.emailsender.dao.ContactRepository;

@RestController
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/contacts")
    public Contact addContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    @PutMapping("/contacts/{id}")
    public Contact updateContact(@RequestBody Contact contact) {
        Contact oldContact = null;
        Optional<Contact> optContact = contactRepository.findById(contact.getId());
        if (optContact.isPresent()) {
            oldContact = optContact.get();
            oldContact.setName(contact.getName());
            oldContact.setEmail(contact.getEmail());
            contactRepository.save(oldContact);
        }else{
            return new Contact();
        }
        return oldContact;
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable int id) {
        return contactRepository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @DeleteMapping("/contact/{id}")
    public Contact deleteContact(@PathVariable int id) {
        Optional<Contact> optContact = contactRepository.findById(id);
        if (optContact.isPresent()) {
            contactRepository.deleteById(id);
            return optContact.get();
        }
        else
            return null;
    }
}
