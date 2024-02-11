package com.example.demo.repo;

import com.example.demo.models.Authorization;
import org.springframework.data.repository.CrudRepository;

public interface AuthorizationRepository extends CrudRepository<Authorization, Long> {
}
