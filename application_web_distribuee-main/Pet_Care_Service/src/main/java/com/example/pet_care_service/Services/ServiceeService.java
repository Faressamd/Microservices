package com.example.pet_care_service.Services;

import com.example.pet_care_service.Entities.Servicee;
import com.example.pet_care_service.Repository.ServiceeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceeService implements IServicee {

    @Autowired
    ServiceeRepository serviceeRepository;

    @Override
    public List<Servicee> retrieveAllServices() {
        return serviceeRepository.findAll();
    }

    @Override
    public Servicee addServicee(Servicee s) {
        return serviceeRepository.save(s);
    }

    @Override
    public void delete(Long id) {
        serviceeRepository.deleteById(id);
    }

    @Override
    public Servicee updateServicee(Servicee s) {
        return serviceeRepository.save(s);
    }

    @Override
    public Servicee retrieveServicee(Long id) {
        return serviceeRepository.findById(id).orElse(null);
    }
}
