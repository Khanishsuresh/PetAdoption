package com.springboot.backend.service;

import java.time.LocalDateTime;
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

    public Inquiry getInquiry(long id) {
        return inquiryRepository.findById(id).orElse(null);
    }

    public Inquiry addInquiry(Inquiry inquiry) {
        return inquiryRepository.save(inquiry);
    }

    public Inquiry updateInquiry(Inquiry inquiry) {
        return inquiryRepository.findById(inquiry.getId())
                .map(existingInquiry -> {
                    existingInquiry.setName(inquiry.getName());
                    existingInquiry.setEmail(inquiry.getEmail());
                    existingInquiry.setMessage(inquiry.getMessage());
                    existingInquiry.setInqueryDateTime(LocalDateTime.now());
                    return inquiryRepository.save(existingInquiry);
                })
                .orElseThrow(() -> new RuntimeException("Inquiry not found with ID: " + inquiry.getId()));
    }

    public String deleteInquiry(long id) {
        inquiryRepository.deleteById(id);
        return "Inquiry removed !! " + id;
    }
}
