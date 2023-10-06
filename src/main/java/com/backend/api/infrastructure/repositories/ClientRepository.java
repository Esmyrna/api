package com.backend.api.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.api.domain.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
