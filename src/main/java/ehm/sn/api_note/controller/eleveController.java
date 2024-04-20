package ehm.sn.api_note.controller;

import ehm.sn.api_note.enties.Eleve;
import ehm.sn.api_note.services.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/eleve")
public class eleveController {

    @Autowired
    private EleveService eleveService;
    @GetMapping
    public List<Eleve> eleves(){
        return eleveService.getEleves();
    }

    @PostMapping()
    public Eleve addEleve(@RequestBody Eleve eleve){
        return eleveService.saveEleve(eleve);
    }

    @GetMapping("/{id}")
    public Eleve eleve(@PathVariable Long id){
        return eleveService.getEleveById(id);
    }

    @PutMapping
    public void updateEleve(@RequestBody Eleve eleve){
         eleveService.updateEleve(eleve);
    }
    @DeleteMapping("/{id}")
    public void deleteEleve(@PathVariable Long id){
        eleveService.deleteEleve(id);
    }

}
