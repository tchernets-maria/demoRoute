package com.example.demo.repo;

import com.example.demo.models.BusStation;
import org.springframework.data.repository.CrudRepository;

public interface BusStationRepository extends CrudRepository<BusStation, Long> {
}
