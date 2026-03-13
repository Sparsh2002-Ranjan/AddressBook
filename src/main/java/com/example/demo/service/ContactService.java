package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;

    public Contact addContact(Contact contact) {
        return repository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    public Contact updateContact(String name, Contact newData) {
        Contact contact = repository.findByFirstName(name);
        contact.setAddress(newData.getAddress());
        contact.setCity(newData.getCity());
        contact.setState(newData.getState());
        contact.setZip(newData.getZip());
        contact.setPhone(newData.getPhone());
        contact.setEmail(newData.getEmail());
        return repository.save(contact);
    }

    public void deleteContact(String name) {
        Contact contact = repository.findByFirstName(name);
        repository.delete(contact);
    }
}
