package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public interface IdentityService {
    Long getIdCompany(String login, String password);
}
