package com.example.pet_care_veterinaire.Services;

import com.example.pet_care_veterinaire.Repository.ServiceeRepository;
import com.example.pet_care_veterinaire.entities.Servicee;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceeService  implements  IServicee{

    private ServiceeRepository rep ;
    @Override
    public Servicee add(Servicee servicee) {
        return rep.save(servicee) ;
    }

    @Transactional
    @Override
    public Servicee update(Servicee servicee ) {
        Servicee S = rep.findById(servicee.getId()).orElse(null);
        S.setDuree(servicee.getDuree());
        S.setNom(servicee.getNom());
        S.setType(servicee.getType());
        S.setPrix(servicee.getPrix());

        return S ;
    }

    @Override
    public void deleate(long id) {
        Servicee S = rep.findById(id).orElse(null);
        rep.delete(S);
    }

    @Override
    public List<Servicee> liste() {
        return rep.findAll();
    }
}
