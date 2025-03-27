package com.springboot.backend.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.backend.model.Inquiry;
import com.springboot.backend.service.InquiryService;

@RestController
@RequestMapping("/api/inquiries")
@CrossOrigin(origins = "http://localhost:3000")
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;

    @GetMapping
    public ResponseEntity<List<Inquiry>> getAllInquiries() {
        return ResponseEntity.ok(inquiryService.getAllInquiries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inquiry> getInquiry(@PathVariable long id) {
        Inquiry inquiry = inquiryService.getInquiry(id);
        return inquiry != null ? ResponseEntity.ok(inquiry) : ResponseEntity.status(404).body(null);
    }

    @PostMapping
    public ResponseEntity<Inquiry> addInquiry(@RequestBody Inquiry inquiry) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inquiryService.addInquiry(inquiry));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inquiry> updateInquiry(@PathVariable long id, @RequestBody Inquiry inquiry) {
        inquiry.setId(id);
        try {
            return ResponseEntity.ok(inquiryService.updateInquiry(inquiry));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInquiry(@PathVariable long id) {
        return inquiryService.deleteInquiry(id);
    }
}
