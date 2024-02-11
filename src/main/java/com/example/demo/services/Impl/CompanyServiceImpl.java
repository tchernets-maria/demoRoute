package com.example.demo.services.Impl;

import com.example.demo.models.Company;
import com.example.demo.repo.CompanyRepository;
import com.example.demo.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public String getName(Long id) {
        return companyRepository.findById(id).orElse(new Company()).getName();
    }

    @Override
    public String getEmail(Long id) {
        return companyRepository.findById(id).orElse(new Company()).getEmail();
    }

    @Override
    public String getPhone(Long id) {
        return companyRepository.findById(id).orElse(new Company()).getPhone();
    }
}
