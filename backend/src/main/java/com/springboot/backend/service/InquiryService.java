package com.springboot.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.backend.repository.InquiryRepository;
import com.springboot.backend.model.Inquiry;


@Service
public class InquiryService {
    
    @Autowired
    private InquiryRepository inquiryRepository;
    
    public List<Inquiry> getAllInquiries() {
        return inquiryRepository.findAll();
    }
}
