package com.esprit.microservice.pet_care_animall.Services;

import com.esprit.microservice.pet_care_animall.Alimentation.Alimentation;
import com.esprit.microservice.pet_care_animall.DTO.PlanAlimentaire;
import com.esprit.microservice.pet_care_animall.Entities.Animal;
import com.esprit.microservice.pet_care_animall.Repositories.AnimalRepository;
import com.esprit.microservice.pet_care_animall.Repositories.DossierMedicalRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AnimalService implements IAnimalService {

    private final AnimalRepository animalRepository;
    private final DossierMedicalRepository dossierMedicalRepository;
    private final Alimentation alimentation;

    @Override
    public Animal addAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Transactional
    @Override
    public Animal editAnimal(Long id, Animal animal) {
        Animal updated = animalRepository.findById(id).orElse(null);
        if (updated != null) {
            updated.setNom(animal.getNom());
            updated.setEspece(animal.getEspece());
            updated.setRace(animal.getRace());
            updated.setAge(animal.getAge());
            updated.setSexe(animal.getSexe());
            return animalRepository.save(updated);
        }
        return null;
    }

    @Override
    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }

    @Override
    public List<Animal> listAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Animal getAnimalById(Long id) {
        return animalRepository.findById(id).orElse(null);
    }

    @Override
    public Animal affecterPlanAnimal(Long idAnimal, Long idPlan) {
        Animal animal = animalRepository.findById(idAnimal).orElse(null);
        if (animal != null) {
            PlanAlimentaire plan = alimentation.getById(idPlan);
            if (animal.getListPlanAlimentation() == null) {
                animal.setListPlanAlimentation(new ArrayList<>());
            }
            animal.getListPlanAlimentation().add(plan.getId());
            return animalRepository.save(animal);
        }
        return null;
    }
}
