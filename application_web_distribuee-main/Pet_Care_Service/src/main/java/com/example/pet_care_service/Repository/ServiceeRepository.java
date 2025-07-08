package com.example.pet_care_service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pet_care_service.Entities.Servicee;

public interface ServiceeRepository extends JpaRepository<Servicee, Long> {
}
