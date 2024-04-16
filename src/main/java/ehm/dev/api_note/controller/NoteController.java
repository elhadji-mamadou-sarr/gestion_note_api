package ehm.dev.api_note.controller;

import ehm.dev.api_note.enties.Bulletin;
import ehm.dev.api_note.enties.Eleve;
import ehm.dev.api_note.enties.Matiere;
import ehm.dev.api_note.enties.Note;
import ehm.dev.api_note.repositories.NoteRepository;
import ehm.dev.api_note.services.EleveService;
import ehm.dev.api_note.services.MatiereService;
import ehm.dev.api_note.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    private EleveService eleveService;
    @Autowired
    private MatiereService matiereService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> getAllNotes(){
        return noteService.getNotes();
    }

    @PostMapping
    public Note addNote(@RequestBody Note note){
        return noteService.addNote(note);
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

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id){
      return noteService.updateNote(id);
    }

    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable Long id){
        return noteService.deleteNote(id);
    }



}
