package com.example.demo.services;

import com.example.demo.models.types.Transport;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

@Service
public interface TransportService {

    String getName(Long id, Transport transport);

    String getCompanyInfo(Long id, Transport transport);

    Pair<Long, Transport> findTransport(String name);
}
