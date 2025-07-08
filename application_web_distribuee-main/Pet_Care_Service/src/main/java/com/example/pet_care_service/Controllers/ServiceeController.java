package com.example.pet_care_service.Controllers;

import com.example.pet_care_service.Entities.Servicee;
import com.example.pet_care_service.Services.IServicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicee")
public class ServiceeController {

    @Autowired
    IServicee iServicee;

    @GetMapping
    public List<Servicee> getAllServices() {
        return iServicee.retrieveAllServices();
    }

    @PostMapping
    public Servicee createService(@RequestBody Servicee s) {
        return iServicee.addServicee(s);
    }

    @PutMapping
    public Servicee updateService(@RequestBody Servicee s) {
        return iServicee.updateServicee(s);
    }

    @DeleteMapping("/{id}")
    public void deleteService(@PathVariable Long id) {
        iServicee.delete(id); // FIXED
    }

    @GetMapping("/{id}")
    public Servicee getService(@PathVariable Long id) {
        return iServicee.retrieveServicee(id);
    }
}
