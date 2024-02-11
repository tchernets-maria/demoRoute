package com.example.demo.repo;

import com.example.demo.models.Bus;
import org.springframework.data.repository.CrudRepository;

public interface BusRepository extends CrudRepository<Bus, Long> {
}
