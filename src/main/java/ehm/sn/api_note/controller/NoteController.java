package ehm.sn.api_note.controller;

import ehm.sn.api_note.enties.Bulletin;
import ehm.sn.api_note.enties.Eleve;
import ehm.sn.api_note.enties.Matiere;
import ehm.sn.api_note.enties.Note;
import ehm.sn.api_note.services.EleveService;
import ehm.sn.api_note.services.MatiereService;
import ehm.sn.api_note.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;
    @Autowired
    private EleveService eleveService;
    @Autowired
    private MatiereService matiereService;


    @GetMapping
    public List<Note> notes(){
        return noteService.notes();
    }

    @PostMapping
    public Note addNote(@RequestBody Note note){
        return noteService.addNote(note);
    }

    @PutMapping
    public void updateNote(@RequestBody Note note){
        noteService.updateNote(note);
    }

    @GetMapping("/eleve/{id}")
    public Bulletin notesByEleve(@PathVariable Long id) {
        Eleve eleve = eleveService.getEleveById(id);
        return noteService.getNoteByEleve(eleve);
    }

    @GetMapping("/matiere/{id}")
    public List<Note> notesByMatiere(@PathVariable Long id){
        Matiere matiere = matiereService.getMatiereById(id);
        return noteService.getNoteByMatiere(matiere);
    }

    @DeleteMapping
    public void deleteNote(@PathVariable Long id){
         noteService.deleteNote(id);
    }



}
