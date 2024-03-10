package com.example.foyer.service.foyer.service.foyer;

import com.example.foyer.service.foyer.entity.Foyer;
import com.example.foyer.service.foyer.repository.FoyerRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class foyerServiceImpl implements IFoyerService {
@Autowired
FoyerRepo foyerRepository;
   // BlocRepo blocRepository;
  //  UniversiteRepo universiteRepository;

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

    /*public Foyer updateFoyerWithAssociations(Foyer updatedFoyer, long id, Long idUniversite, List<Long> idBloc) {
        Foyer existingFoyer = foyerRepository.findById(id).orElse(null);


        // Update Foyer properties
        existingFoyer.setNomFoyer(updatedFoyer.getNomFoyer());
        existingFoyer.setCapaciteFoyer(updatedFoyer.getCapaciteFoyer());

        // Update Bloc associations
        if (idBloc != null && !idBloc.isEmpty()) {
            List<Bloc> newBlocs = blocRepository.findAllById(idBloc);
            existingFoyer.getBloc().forEach(bloc -> {
                if (!newBlocs.contains(bloc)) {
                    bloc.setFoyer(null);
                    blocRepository.save(bloc);
                }
            });

            newBlocs.forEach(bloc -> {
                if (!existingFoyer.getBloc().contains(bloc)) {
                    bloc.setFoyer(existingFoyer);
                    blocRepository.save(bloc);
                }
            });
        }

        // Update Universite association
        if (idUniversite != null) {
            Universite newUniversite = universiteRepository.findById(idUniversite).orElse(null);
            Universite oldUniversite = existingFoyer.getUniversite();

            if (oldUniversite != null && !oldUniversite.equals(newUniversite)) {
                oldUniversite.setFoyer(null);
                universiteRepository.save(oldUniversite);
            }

            if (newUniversite != null) {
                newUniversite.setFoyer(existingFoyer);
                universiteRepository.save(newUniversite);
            }
        }

        return foyerRepository.save(existingFoyer);
    }
*/

    @Override
    public List<Foyer> findAll() {
        return foyerRepository.findAll();
    }

   // @Override
  //  public Foyer findById(long id) {
     //   return foyerRepository.findById(id).get();
    //}
   @Override
   public Foyer findById(long id) {
       Optional<Foyer> optionalFoyer = foyerRepository.findById(id);
       return optionalFoyer.orElse(null); // or throw an exception if needed
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
