package com.example.csvmodify.controller;

import com.example.csvmodify.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contact")
@AllArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public void saveContact(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {
        contactService.saveContactCSV(firstName, lastName, email);
    }
}
