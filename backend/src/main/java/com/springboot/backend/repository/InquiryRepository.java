package com.springboot.backend.repository;

import com.springboot.backend.model.Inquiry;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InquiryRepository extends JpaRepository <Inquiry, Long> {

}