package com.example.foyer.Controller;


import com.example.foyer.entity.Foyer;
import com.example.foyer.service.foyer.IFoyerService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Getter
@Setter
@AllArgsConstructor
@RequestMapping("/api/foyers")
public class FoyerRestController {

    IFoyerService iFoyerService;
   // BlocRepo blocRepository;

    @GetMapping("findAllF")
    List<Foyer> findAll(){
        return iFoyerService.findAll();
    }

    @PostMapping("/addFoyer")
    Foyer addFoyer(@RequestBody Foyer f){
        return iFoyerService.addFoyer(f);
    }

    @PutMapping("UpdateFoyer")
    Foyer updateFoyer(@RequestBody Foyer f){
        return iFoyerService.editFoyer(f);
    }
    @PutMapping("/UpdateFoyer/{id}")
    Foyer updateFoyerId(@RequestBody Foyer f, @PathVariable long id) {
        f.setIdFoyer(id); // Set the ID from the path variable
        return iFoyerService.editFoyer(f);
    }

    @DeleteMapping("DeleteFoyer")
    void DeleteFoyer(@RequestBody Foyer f){
        iFoyerService.delete(f);
    }

    @DeleteMapping("/DeleteFoyer/{id}")
    public void DeleteFoyerById(@PathVariable long id) {
        iFoyerService.deleteById(id);
    }


}
