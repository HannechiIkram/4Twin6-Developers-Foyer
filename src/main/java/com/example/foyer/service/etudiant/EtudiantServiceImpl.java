package com.example.foyer.service.etudiant;

import com.example.foyer.entity.Etudiant;
import com.example.foyer.service.IEtudiantService;
import com.example.foyer.repository.EtudiantRepository;


import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Builder
@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService
{
    @Autowired
    EtudiantRepository e;


    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return e.save(etudiant);
    }

    @Override
    public List<Etudiant> addAllEtudiant(List<Etudiant> liste) {
        return e.saveAll(liste);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return e.findAll();
    }

    @Override
    public Etudiant findById(Long id) {
        Optional<Etudiant> optionalEtudiant = e.findById(id);
        if (optionalEtudiant.isPresent()) {
            return optionalEtudiant.get();
        } else {
            throw new EntityNotFoundException("Etudiant with ID " + id + " not found");
        }
    }
    @Override
    public void deleteById(Long id) {
        if (!e.existsById(id)) {
            throw new EmptyResultDataAccessException("Etudiant with ID " + id + " not found", 1);
        }
        e.deleteById(id);
    }

    @Override
    public void deleteAll() {
        e.deleteAll();
    }


    @Override
    public Etudiant editEtudiant(Long id, Etudiant etudiant) throws ChangeSetPersister.NotFoundException {
        Optional<Etudiant> optionalEtudiant = e.findById(id);
        if (optionalEtudiant.isPresent()) {
            Etudiant existingEtudiant = optionalEtudiant.get();
            existingEtudiant.setNomEt(etudiant.getNomEt());
            existingEtudiant.setPrenomEt(etudiant.getPrenomEt());
            existingEtudiant.setCin(etudiant.getCin());
            existingEtudiant.setEmail(etudiant.getEmail());
            existingEtudiant.setEcole(etudiant.getEcole());
            existingEtudiant.setDateNaissance(etudiant.getDateNaissance());
            existingEtudiant.setMdp(etudiant.getMdp());
            return e.save(existingEtudiant);
        } else {
            // Handle the case where the etudiant with the given ID doesn't exist
            throw new ChangeSetPersister.NotFoundException();
        }
    }


    @Override
    public Etudiant findEtudiantByCin(Long cin) {
        Optional<Etudiant> optionalEtudiant = Optional.ofNullable(e.findEtudiantByCin(cin));
        if (optionalEtudiant.isPresent()) {
            return optionalEtudiant.get();
        } else {
            throw new EntityNotFoundException("Etudiant with Cin " + cin + " not found");
        }
    }

    @Override
    public Etudiant findEtudiantByEmail(String em) {
        Optional<Etudiant> optionalEtudiant = Optional.ofNullable(e.findEtudiantByEmail(em));
        if (optionalEtudiant.isPresent()) {
            return optionalEtudiant.get();
        } else {
            throw new EntityNotFoundException("Etudiant with Email " + em + " not found");
        }
    }

}
