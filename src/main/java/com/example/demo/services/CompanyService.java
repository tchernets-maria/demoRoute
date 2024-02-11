package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public interface CompanyService {

    String getName(Long id);

    String getEmail(Long id);

    String getPhone(Long id);

}
