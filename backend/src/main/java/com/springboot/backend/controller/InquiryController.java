package com.springboot.backend.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;

import com.springboot.backend.model.Inquiry;
import com.springboot.backend.service.InquiryService;

@RestController
@RequestMapping("/api/inquiry")
@CrossOrigin(origins = "http://localhost:3000")
public class InquiryController {

    private InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @GetMapping("/all")
    public List<Inquiry> getAllInquiries() {
        return inquiryService.getAllInquiries();
    }

    @GetMapping("/get/{id}")
    public Inquiry getInquiry(@PathVariable long id) {
        return inquiryService.getInquiry(id);
    }

    @PostMapping("/add")
    public Inquiry addInquiry(@RequestBody Inquiry inquiry) {
        return inquiryService.addInquiry(inquiry);
    }

    @PutMapping("/update/{id}")
    public Inquiry updateInquiry(@PathVariable long id, @RequestBody Inquiry inquiry) {
        inquiry.setId(id);
        return inquiryService.updateInquiry(inquiry);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInquiry(@PathVariable long id) {
        return inquiryService.deleteInquiry(id);
    }
}
