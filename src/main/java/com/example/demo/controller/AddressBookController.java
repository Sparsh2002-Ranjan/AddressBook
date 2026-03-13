package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Contact;
import com.example.demo.service.ContactService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private ContactService service;

    @PostMapping("/add")
    public Contact addContact(@RequestBody Contact contact) {
        return service.addContact(contact);
    }

    @GetMapping("/all")
    public List<Contact> getContacts() {
        return service.getAllContacts();
    }

    @PutMapping("/update/{name}")
    public Contact update(@PathVariable String name,@RequestBody Contact contact) {
        return service.updateContact(name, contact);
    }

    @DeleteMapping("/delete/{name}")
    public void delete(@PathVariable String name) {
        service.deleteContact(name);
    }
}