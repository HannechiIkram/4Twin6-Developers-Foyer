package com.example.foyer.service.etudiant;

import com.example.foyer.entity.Etudiant;
import com.example.foyer.service.IEtudiantService;
import com.example.foyer.repository.EtudiantRepository;


import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Builder
@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService
{
    @Autowired
    EtudiantRepository e;


    @Override
    public Long addEtudiant(Etudiant etudiant) {
        return e.save(etudiant).getIdEtudiant();
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
        return e.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        e.deleteById(id);
    }

    @Override
    public void deleteAll() {
        e.deleteAll();
    }


    @Override
    public Etudiant editEtudiant(Long id, Etudiant etudiant) {
        if (e.findById(id).isPresent()) {
            Etudiant etudiant1 = e.findById(id).get();
            etudiant1.setNomEt(etudiant.getNomEt());
            etudiant1.setPrenomEt(etudiant.getPrenomEt());
            etudiant1.setCin(etudiant.getCin());
            etudiant1.setEmail(etudiant.getEmail());
            etudiant1.setEcole(etudiant.getEcole());
            etudiant1.setDateNaissance(etudiant.getDateNaissance());
            etudiant1.setMdp(etudiant.getMdp());
            return e.save(etudiant1);
        }
        return null;
    }

    @Override
    public Etudiant findEtudiantByCin(Long cin) {
        return e.findEtudiantByCin(cin);
    }

    @Override
    public Etudiant findEtudiantByEmail(String em) {
        return  e.findEtudiantByEmail(em);
    }

}
