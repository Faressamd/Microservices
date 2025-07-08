package com.example.pet_care_veterinaire.Controllers;

import com.example.pet_care_veterinaire.entities.Veterinaire;
import com.example.pet_care_veterinaire.Services.IVeterianire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinaires")
public class VeterinaireController {

    @Autowired
    IVeterianire iVeterianire;

    @GetMapping
    public List<Veterinaire> getAllVeterinaires() {
        return iVeterianire.retrieveAllVeterinaires();
    }

    @PostMapping
    public Veterinaire createVeterinaire(@RequestBody Veterinaire v) {
        return iVeterianire.addVeterinaire(v);
    }

    @PutMapping
    public Veterinaire updateVeterinaire(@RequestBody Veterinaire v) {
        return iVeterianire.updateVeterinaire(v);
    }

    @DeleteMapping("/{id}")
    public void deleteVeterinaire(@PathVariable Long id) {
        iVeterianire.delete(id); // FIXED spelling
    }

    @GetMapping("/{id}")
    public Veterinaire getVeterinaire(@PathVariable Long id) {
        return iVeterianire.retrieveVeterinaire(id);
    }
}
