package com.example.foyer.service.foyer.service.foyer;

import com.example.foyer.service.foyer.entity.Foyer;
import com.example.foyer.service.foyer.repository.FoyerRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
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
@Override
    public Foyer updateFoyerCapacity(long id, long newCapacity) {
        Optional<Foyer> optionalFoyer = foyerRepository.findById(id);
        if (optionalFoyer.isPresent()) {
            Foyer foyer = optionalFoyer.get();
            foyer.setCapaciteFoyer(newCapacity);
            return foyerRepository.save(foyer);
        } else {
            return null; // or throw an exception indicating foyer not found
        }
    }
    // Existing methods...

    @Override
    public List<Foyer> findAllByCapacityGreaterThan(long capacity) {
        return foyerRepository.findAllByCapaciteFoyerGreaterThan(capacity);
    }

    @Override
    public List<Foyer> findAllByCapacityLessThan(long capacity) {
        return foyerRepository.findAllByCapaciteFoyerLessThan(capacity);
    }

    @Override
    public List<Foyer> findAllFoyersSortedByName() {
        return foyerRepository.findAll(Sort.by(Sort.Direction.ASC, "nomFoyer"));
    }

    @Override
    public List<Foyer> findAllFoyersSortedByCapacity() {
        return foyerRepository.findAll(Sort.by(Sort.Direction.ASC, "capaciteFoyer"));
    }

    @Override
    public List<Foyer> findAllFoyersSortedByCapacityDesc() {
        return foyerRepository.findAll(Sort.by(Sort.Direction.DESC, "capaciteFoyer"));
    }

    @Override
    public List<Foyer> findAllFoyersSortedByNomFoyerLength() {
        return foyerRepository.findAll(Sort.by(Sort.Direction.ASC, "nomFoyer").and(Sort.by("capaciteFoyer")));
    }

    @Override
    public List<Foyer> findAllFoyersWithCapacityInRange(long minCapacity, long maxCapacity) {
        return foyerRepository.findAllByCapaciteFoyerBetween(minCapacity, maxCapacity);
    }

    @Override
    public List<Foyer> findAllFoyersWithNamesContaining(String searchTerm) {
        return foyerRepository.findAllByNomFoyerContaining(searchTerm);
    }

    @Override
    public List<Foyer> findAllFoyersWithNamesStartingWith(String prefix) {
        return foyerRepository.findAllByNomFoyerStartingWith(prefix);
    }

    @Override
    public List<Foyer> findAllFoyersWithNamesEndingWith(String suffix) {
        return foyerRepository.findAllByNomFoyerEndingWith(suffix);
    }

    @Override
    public List<Foyer> findAllFoyersWithNamesContainingIgnoreCase(String searchTerm) {
        return foyerRepository.findAllByNomFoyerContainingIgnoreCase(searchTerm);
    }

    @Override
    public List<Foyer> findAllFoyersWithNamesStartingWithIgnoreCase(String prefix) {
        return foyerRepository.findAllByNomFoyerStartingWithIgnoreCase(prefix);
    }

    @Override
    public List<Foyer> findAllFoyersWithNamesEndingWithIgnoreCase(String suffix) {
        return foyerRepository.findAllByNomFoyerEndingWithIgnoreCase(suffix);
    }

}
