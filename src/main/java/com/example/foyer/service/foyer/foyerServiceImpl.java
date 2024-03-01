package com.example.foyer.service.foyer;

import com.example.foyer.entity.Bloc;
import com.example.foyer.entity.Foyer;
import com.example.foyer.repository.BlocRepo;
import com.example.foyer.repository.FoyerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class foyerServiceImpl implements IFoyerService {

    FoyerRepo foyerRepository;
    BlocRepo blocRepository;
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

    @Override
    public List<Foyer> findAll() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer findById(long id) {
        return foyerRepository.findById(id).get();
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
    public List<Foyer> getFoyersByBloc(Bloc bloc) {
        return foyerRepository.findByBloc(bloc);
    }

    @Override
    public Foyer ajoutFoyerEtBloc(Foyer foyer) {
        Foyer f = foyerRepository.save(foyer);
        for (Bloc b : foyer.getBloc()) {
            b.setFoyer(f);
            blocRepository.save(b);
        }
        return f;

    }

    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        List<Bloc> blocs = blocRepository.findByNomBloc(nomBloc);
        List<Foyer> foyers = foyerRepository.findByNomFoyer(nomFoyer);
        Foyer foyer = foyers.get(0);
        for (Bloc bloc : blocs) {
            bloc.setFoyer(foyer);
            blocRepository.save(bloc);
        }
        Bloc bloc = blocs.get(0);
        bloc.setFoyer(foyer);
        blocRepository.save(bloc);
        return bloc;
    }

    @Override
    public List<Foyer> findByNomFoyer(String nomFoyer) {
        return foyerRepository.findByNomFoyer(nomFoyer);
    }

}
