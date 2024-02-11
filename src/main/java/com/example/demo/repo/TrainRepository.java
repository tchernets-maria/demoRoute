package com.example.demo.repo;

import com.example.demo.models.Train;
import org.springframework.data.repository.CrudRepository;

public interface TrainRepository extends CrudRepository<Train, Long> {
}
