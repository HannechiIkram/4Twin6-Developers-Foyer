

import com.example.foyer.entity.Etudiant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.foyer.service.IEtudiantService;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Etudiants")

public class EtudiantRestController {
    @Autowired
    @JsonIgnore
    IEtudiantService service;

    @PostMapping("/addEtudiant")
    public Long addEtudiant(@RequestBody Etudiant e) {return service.addEtudiant(e);}
    @PostMapping("/addEtudiants")
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> liste)
    {
        return service.addAllEtudiant(liste);
    }

    @DeleteMapping("/deletebyid/{id}")
    void deleteEtudiantByID(@PathVariable("id") Long id){
        service.deleteById(id);
    }
    @DeleteMapping("/deleteall") String deleteAll(){service.deleteAll();return "all students are deleted";
    }
    @PutMapping("updateEtudiant/{id}")
    Etudiant updateEtudiant(@PathVariable("id") Long id ,@RequestBody Etudiant e){
        return  service.editEtudiant(id,e);
    }


    @GetMapping("/getEtudiants")
    public ResponseEntity<List<Etudiant>> getAllEtudiants(){
        List<Etudiant> liste=service.getAllEtudiants();
        return new ResponseEntity<>(liste, HttpStatus.OK);
    }
    @GetMapping("/getby/{id}") Etudiant findById(@PathVariable("id") Long id){ return service.findById(id);}



    @GetMapping("/getbycin/{cin}")
    public ResponseEntity<Etudiant> findEtudiantBycin(@PathVariable("cin") Long cin){
        Etudiant l=service.findEtudiantByCin(cin);
        return ResponseEntity.ok(l);}
}












