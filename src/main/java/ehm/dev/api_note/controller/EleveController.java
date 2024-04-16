package ehm.dev.api_note.controller;

import ehm.dev.api_note.enties.Eleve;
import ehm.dev.api_note.services.EleveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/eleve")
public class EleveController {

    private EleveService eleveService;
    public EleveController(EleveService eleveService) {
        this.eleveService = eleveService;
    }

    @GetMapping
    public List<Eleve> eleveList(){
        return eleveService.getEleves();
    }

    @GetMapping("/{id}")
    public Eleve getEleve(@PathVariable Long id){
        return eleveService.getEleveById(id);
    }

    @PostMapping
    public Eleve addEleve(@RequestBody Eleve eleve){
        return eleveService.saveEleve(eleve);
    }

    @PutMapping
    public Eleve updateEleve(@RequestBody Eleve eleve){
        return  eleveService.updateEleve(eleve);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEleve(@PathVariable Long id){
        return  eleveService.deleteEleve(getEleve(id));
    }


}
