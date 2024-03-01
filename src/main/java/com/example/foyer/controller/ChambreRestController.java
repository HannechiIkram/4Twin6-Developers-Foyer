package com.example.foyer.controller;

import com.example.foyer.entity.Chambre;
import com.example.foyer.entity.TypeChambre;

import com.example.foyer.service.chambre.IChambreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/chambres")

public class ChambreRestController {
    IChambreService iChambreService;
    //IBlocService iBlocService;

    @GetMapping("/findAllC")
    List<Chambre> findAll(){
        return iChambreService.findAll();
    }

    @PostMapping("/addChambre")
    Chambre addChambre(@RequestBody Chambre c){
        return iChambreService.addChambre(c);
    }

    @PutMapping("updateChambre")
    Chambre editChamber(@RequestBody Chambre c){
        return iChambreService.editChambre(c);
    }

    @DeleteMapping("deleteChamberById/{id}")
    String DeleteChamberByID(@PathVariable("id") long id){
        return iChambreService.deleteById(id);
    }

    @DeleteMapping("deleteChambre")
    void DeleteChambre(@RequestBody Chambre c){
        iChambreService.delete(c);
    }

    @GetMapping("/findChambreByNumero/{numeroChambre}")
    public Chambre findChambreByNumero(@PathVariable("numeroChambre") long numeroChambre) {
        return iChambreService.findChambreByNumero(numeroChambre);
    }

    @GetMapping("/findChambreByType/{typeChambre}")
    public List<Chambre> findChambreByType(@PathVariable("typeChambre") TypeChambre typeChambre) {
        return iChambreService.findChambreByType(typeChambre);
    }


   /* @GetMapping("/chambres/searchByBloc")
    public List<Chambre> searchChambresByBloc(@RequestParam("idBloc") long idBloc) {
        Bloc bloc = iBlocService.findById(idBloc);
        if (bloc != null) {
            return iChambreService.findByBloc(bloc);
        } else {

            return Collections.emptyList();
        }
    }*/

   /* @GetMapping("/parNomBloc")
    public List<Chambre> getChambresParNomBloc(@RequestParam("nomBloc") String nomBloc) {
        return iChambreService.getChambresParNomBloc(nomBloc);
    }

    */
  /*  @GetMapping("nbChambreParTypeEtBloc/{type}/{idBloc}")
    long nbChambreParTypeEtBloc(@PathVariable("type") TypeChambre type , @PathVariable("idBloc") long idBloc){
        return iChambreService.nbChambreParTypeEtBloc(type , idBloc);
    }

   */

    @GetMapping("/pourcentageChambreParTypeChambre")
    public String pourcentageChambreParTypeChambre() {
        iChambreService.pourcentageChambreParTypeChambre();
        return "Opération réussie. ";
    }


    /*@GetMapping("chambreListNonReserve/{type}/{nomFoyer}")
    List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(@PathVariable("type") TypeChambre type , String nomFoyer)
    {
        return iChambreService.getChambresNonReserveParNomFoyerEtTypeChambre(nomFoyer , type);
    }*/

    @GetMapping("/getChambreById/{idChambre}")
    public Chambre getChambreByIdChambre(@PathVariable("idChambre") long idChambre) {
        return iChambreService.getChambreByIdChambre(idChambre);
    }
    @PutMapping("updateChambreById/{idChambre}")
    Chambre updateChambre(@RequestBody Chambre c){
        return iChambreService.UpdateChambreById(c);
    }


  /*  @GetMapping("/par-bloc/{nomBloc}")
    public List<Chambre> getChambresByBloc(@PathVariable String nomBloc) {
        return iChambreService.getChambresByBloc(nomBloc);
    }*/
}
