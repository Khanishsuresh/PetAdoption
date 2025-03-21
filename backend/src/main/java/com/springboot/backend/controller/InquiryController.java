package com.springboot.backend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.model.Inquiry;
import com.springboot.backend.service.InquiryService;

@RestController
@RequestMapping("/api/inquiry")
public class InquiryController {

    private InquiryService inquiryService;
    public InquiryController (InquiryService inquiryService){
        this.inquiryService = inquiryService;
    }
    
    @GetMapping("/all")
    public List<Inquiry> getAllInquiries() {
        return inquiryService.getAllInquiries();
    }
}
