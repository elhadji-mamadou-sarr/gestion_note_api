package ehm.dev.api_note.controller;

import ehm.dev.api_note.enties.Matiere;
import ehm.dev.api_note.services.MatiereService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/matiere")
public class MatiereController {

    private  MatiereService matiereService;

    public MatiereController(MatiereService matiereService) {
        this.matiereService = matiereService;
    }

    @GetMapping
    public List<Matiere> getMatieres(){
        return matiereService.getMatieres();
    }

    @GetMapping("/{id}")
    public Matiere getMatiere(@PathVariable Long id){
        return matiereService.getMatiereById(id);
    }

    @PostMapping
    public Matiere addMatiere(@RequestBody Matiere matiere){
        return  matiereService.saveMatiere(matiere);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Matiere> updateMatiere(@PathVariable Long id, @RequestBody Matiere matiere){
        return ResponseEntity.ok(matiereService.updateMatiere(id, matiere));
    }

    @DeleteMapping("/{id}")
    public String deleteMatiere(@PathVariable Long id){
        return matiereService.deleteMatiere(id);
    }

}
