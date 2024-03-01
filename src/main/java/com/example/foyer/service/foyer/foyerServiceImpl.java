package com.example.foyer.service.foyer;

import com.example.foyer.entity.Foyer;
import com.example.foyer.repository.FoyerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class foyerServiceImpl implements IFoyerService {

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
    public List<Foyer> findByNomFoyer(String nomFoyer) {
        return foyerRepository.findByNomFoyer(nomFoyer);
    }

   /* @Override
    public List<Foyer> getFoyersByBloc(Bloc bloc) {
        return foyerRepository.findByBloc(bloc);
    }*/

   /* @Override
    public Foyer ajoutFoyerEtBloc(Foyer foyer) {
        Foyer f = foyerRepository.save(foyer);
        for (Bloc b : foyer.getBloc()) {
            b.setFoyer(f);
            blocRepository.save(b);
        }
        return f;
    }
*/
  /*  @Override
    public Foyer ajouterFoyerEtAffecteUniversite(Foyer foyer, long idUniversite) {
        Universite uni = universiteRepository.findById(idUniversite).get();
        Foyer fo = foyerRepository.save(foyer);
        uni.setFoyer(fo);
        universiteRepository.save(uni);
        return foyer;
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        List<Universite> universites = universiteRepository.findByNomUniversite(nomUniversite);
        Universite universite = universites.get(0);
        universite.setFoyer(foyer);
        universiteRepository.save(universite);

        return universite;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        universite.setFoyer(null); // Désaffectez le foyer en définissant null
        return universiteRepository.save(universite);
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
    public void deleteFoyerAndDesaffecterUniversite(Long id) {
        Foyer foyer = foyerRepository.findById(id).orElse(null);
        if (foyer != null) {
            List<Bloc> blocs = foyer.getBloc();
            // Remove the association ll bloc
            blocs.forEach(bloc -> {
                bloc.setFoyer(null);
                blocRepository.save(bloc);
            });

            Universite universite = foyer.getUniversite();
            if (universite != null) {
                universite.setFoyer(null);
                try {
                    universiteRepository.save(universite);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            foyerRepository.deleteById(id);
        }
    }

    public Foyer addFoyerAndAssociateUniversiteAndBloc(Foyer foyer, long idUniversite, List<Long> idBloc) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        if (universite != null) {
            foyer.setUniversite(universite);
            foyer = foyerRepository.save(foyer);
            // Associate multiple Bloc
            for (Long blocId : idBloc) {
                Bloc bloc = blocRepository.findById(blocId).orElse(null);
                if (bloc != null) {
                    bloc.setFoyer(foyer);
                    foyer.getBloc().add(bloc);
                }
            }
            universite.setFoyer(foyer);
            universiteRepository.save(universite);
            foyer = foyerRepository.save(foyer);
        }
        return foyer;
    }*/
}
