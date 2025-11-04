package com.springboot.backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.backend.model.Inquiry;
import com.springboot.backend.repository.InquiryRepository;

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
        if (inquiry == null) {
            throw new IllegalArgumentException("Inquiry cannot be null");
        }
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

    public ResponseEntity<String> deleteInquiry(long id) {
        if(inquiryRepository.existsById(id)) {
            inquiryRepository.deleteById(id);
            return ResponseEntity.ok("Inquiry removed !! " + id);
        } else {
            return ResponseEntity.status(404).body("Inquiry not found with ID: " + id);
        }
    }
}
