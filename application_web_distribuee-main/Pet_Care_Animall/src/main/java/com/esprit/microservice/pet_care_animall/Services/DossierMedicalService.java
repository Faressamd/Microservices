package com.esprit.microservice.pet_care_animall.Services;

import com.esprit.microservice.pet_care_animall.Entities.Animal;
import com.esprit.microservice.pet_care_animall.Entities.DossierMedical;
import com.esprit.microservice.pet_care_animall.Repositories.AnimalRepository;
import com.esprit.microservice.pet_care_animall.Repositories.DossierMedicalRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DossierMedicalService implements IDossierMedicalService {

    private final AnimalRepository animalRepository;
    private final DossierMedicalRepository dossierMedicalRepository;

    @Override
    public DossierMedical addDossierMedical(Long animalId, DossierMedical dossier) {
        Animal animal = animalRepository.findById(animalId).orElse(null);
        if (animal != null) {
            dossier.setAnimal(animal);
            return dossierMedicalRepository.save(dossier);
        }
        return null;
    }

    @Transactional
    @Override
    public DossierMedical editDossierMedical(Long id, DossierMedical details) {
        DossierMedical existing = dossierMedicalRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setDiagnostic(details.getDiagnostic());
            existing.setTraitement(details.getTraitement());
            existing.setNotes(details.getNotes());
            return dossierMedicalRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteDossierMedical(Long id) {
        dossierMedicalRepository.deleteById(id);
    }

    @Override
    public List<DossierMedical> listDossiersMedical() {
        return dossierMedicalRepository.findAll();
    }

    @Override
    public DossierMedical getDossierMedicalById(Long id) {
        return dossierMedicalRepository.findById(id).orElse(null);
    }
}
