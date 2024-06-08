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

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Builder
@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService
{
    @Autowired
    EtudiantRepository e;
    private static final String MSG_NOT_FOUND = "not found";

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
            throw new EntityNotFoundException("Etudiant with ID " + id + MSG_NOT_FOUND);
        }
    }
    @Override
    public void deleteById(Long id) {
        if (!e.existsById(id)) {
            throw new EmptyResultDataAccessException("Etudiant with ID " + id + MSG_NOT_FOUND, 1);
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
            throw new EntityNotFoundException("Etudiant with Cin " + cin + MSG_NOT_FOUND);
        }
    }

    @Override
    public Etudiant findEtudiantByEmail(String em) {
        Optional<Etudiant> optionalEtudiant = Optional.ofNullable(e.findEtudiantByEmail(em));
        if (optionalEtudiant.isPresent()) {
            return optionalEtudiant.get();
        } else {
            throw new EntityNotFoundException("Etudiant with Email " + em + MSG_NOT_FOUND
            );
        }
    }

    @Override
    public Etudiant updateEtudiantEmail(Long id, String newEmail) throws ChangeSetPersister.NotFoundException {
        Optional<Etudiant> optionalEtudiant = e.findById(id);
        if (optionalEtudiant.isPresent()) {
            Etudiant existingEtudiant = optionalEtudiant.get();
            existingEtudiant.setEmail(newEmail);
            return e.save(existingEtudiant);
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    @Override
    public List<Etudiant> findEtudiantsByEcole(String ecole) {
        return null;
    }

    @Override
    public List<Etudiant> findEtudiantsByDateOfBirth(Date dateOfBirth) {
        return null;
    }

    @Override
    public long countEtudiants() {
        return 0;
    }

    @Override
    public boolean existsByEmail(String email) {
        return false;
    }
    // Method to update the email of an existing etudiant


}
