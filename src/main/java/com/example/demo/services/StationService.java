package com.example.demo.services;

import com.example.demo.models.types.Station;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

@Service
public interface StationService {

    String getName(Long id, Station station);

    String getAddress(Long id, Station station);

    Pair<Long, Station> findStation(String name);
}
