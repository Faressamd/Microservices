package com.example.pet_care_service.Services;

import java.util.List;

import com.example.pet_care_service.Entities.Servicee;

public interface IServicee {
    List<Servicee> retrieveAllServices();
    Servicee addServicee(Servicee s);
    void delete(Long id); // FIXED from "deleate"
    Servicee updateServicee(Servicee s);
    Servicee retrieveServicee(Long id);
}
