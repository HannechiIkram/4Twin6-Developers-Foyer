package com.example.foyer.service.bloc;

import com.example.foyer.entity.Bloc;
import com.example.foyer.entity.Chambre;
import com.example.foyer.entity.Foyer;
import com.example.foyer.repository.BlocRepo;
import com.example.foyer.repository.ChambreRepo;
import com.example.foyer.repository.FoyerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class BlocServiceImpl implements IBlocService{
    @Autowired

    BlocRepo blocRepository;
    ChambreRepo chambreRepository;
    FoyerRepo foyerRepo;

  @Override
    public Bloc addBloc(Bloc b) {
        List<Chambre> chambres = (List<Chambre>) b.getChambres();
        b = blocRepository.save(b);
        for (Chambre chambre : chambres) {
            chambre.setBloc(b);
            chambreRepository.save(chambre);
        }
        return b; //on ajoute une ligne
    }



    @Override
    public List<Bloc> addBlocs(List<Bloc> blocs) {
        return blocRepository.saveAll(blocs); //on ajoute Des lignes dans la BD
    }

    @Override
    public Bloc editBloc(Bloc b) {
        return blocRepository.save(b); //pour faire la modification
    }

    @Override
    public List<Bloc> findAll() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc findById(long id) {
        // return blocRepository.findById(id).get();
        //ou bien
        //ou bien
        return blocRepository.findById(id).orElse(Bloc.builder().idBloc(0).nomBloc("pas de bloc").build());


    }

    @Override
    public void deleteById(long id) {
        blocRepository.deleteById(id);

    }

    @Override
    public void delete(Bloc b) {
        blocRepository.delete(b);

    }

    @Override
    public List<Bloc> findByNomBloc(String nomBloc) {
        return blocRepository.findByNomBloc(nomBloc);
    }

    @Override
    public List<Bloc> findByCapaciteBloc(int capaciteBloc) {
        return blocRepository.findByCapaciteBloc(capaciteBloc);
    }

    @Override
    public List<Bloc> findByNomBlocAndCapaciteBloc(String nomBloc, int capaciteBloc) {
        return blocRepository.findByNomBlocAndCapaciteBloc(nomBloc, capaciteBloc);
    }

    @Override
    public List<Bloc> findByNomBlocIgnoreCase(String nomBloc) {
        return blocRepository.findByNomBlocIgnoreCase(nomBloc);
    }

    @Override
    public List<Bloc> findByCapaciteBlocGreaterThan(int capacite) {
        return blocRepository.findByCapaciteBlocGreaterThan(capacite);
    }

    @Override
    public List<Bloc> findByNomBlocContaining(String subString) {
        return blocRepository.findByNomBlocContaining(subString);
    }

    @Override
    public List<Bloc> findAllByOrderByNomBlocAsc() {
        return blocRepository.findAllByOrderByNomBlocAsc();
    }

    @Override
    public List<Bloc> findByNomBlocOrCapaciteBloc(String nomBloc, int capaciteBloc) {
        return blocRepository.findByNomBlocOrCapaciteBloc(nomBloc, capaciteBloc);
    }





}
