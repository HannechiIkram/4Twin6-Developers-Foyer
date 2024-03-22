package com.example.foyer.service.foyer.service.foyer;

import com.example.foyer.service.foyer.entity.Foyer;
import com.example.foyer.service.foyer.repository.FoyerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService {
FoyerRepo foyerRepository;

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public List<Foyer> addFoyers(List<Foyer> foyers) {
        return foyerRepository.saveAll(foyers);
    }

    @Override
    public Foyer editFoyer(Foyer f) {
        return foyerRepository.save(f);
    }



    @Override
    public List<Foyer> findAll() {
        return foyerRepository.findAll();
    }

   @Override
   public Foyer findById(long id) {
       Optional<Foyer> optionalFoyer = foyerRepository.findById(id);
       return optionalFoyer.orElse(null);
   }

    @Override
    public void deleteById(long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public void delete(Foyer f) {
        foyerRepository.delete(f);
    }

    @Override
    public List<Foyer> findByNomFoyer(String nomFoyer) {
        return foyerRepository.findByNomFoyer(nomFoyer);
    }




}
