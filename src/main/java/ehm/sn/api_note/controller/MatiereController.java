package ehm.sn.api_note.controller;

import ehm.sn.api_note.enties.Matiere;
import ehm.sn.api_note.services.MatiereService;
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

    @PutMapping
    public void updateMatiere(@RequestBody Matiere matiere){
         matiereService.updateMatiere(matiere);
    }

    @DeleteMapping("/{id}")
    public void deleteMatier(@PathVariable Long id){
        matiereService.deleteMatiere(id);
    }

}
