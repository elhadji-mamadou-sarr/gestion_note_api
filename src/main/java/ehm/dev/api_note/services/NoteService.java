package ehm.dev.api_note.services;

import ehm.dev.api_note.enties.Bulletin;
import ehm.dev.api_note.enties.Eleve;
import ehm.dev.api_note.enties.Matiere;
import ehm.dev.api_note.enties.Note;
import ehm.dev.api_note.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getNotes(){
        return noteRepository.findAll();
    }

    public Note addNote(Note note){
        Long notes = (note.getNote_1() + note.getNote_2()) / 2;
        Long moyenne = (notes + note.getIntegration()) / 2;
        note.setMoyenne(moyenne);
        note.setMoyX(moyenne * note.getMatiere().getCoef());
        return noteRepository.save(note);
    }

    public Note updateNote(Long id){
        Optional<Note> noteOptional = noteRepository.findById(id);
        if (noteOptional.isPresent()) {
            Long notes = (noteOptional.get().getNote_1() + noteOptional.get().getNote_2()) / 2;
            Long moyenne = (notes + noteOptional.get().getIntegration()) / 2;
            noteOptional.get().setMoyenne(moyenne);
            noteOptional.get().setMoyX(moyenne * noteOptional.get().getMatiere().getCoef());
            return noteRepository.save(noteOptional.get());
        }else{
            throw new RuntimeException("Note non trouvé !");
        }
    }

    public Bulletin getNoteByEleve(Eleve eleve){
        Bulletin bulletin = new Bulletin();
        List<Note> notes = noteRepository.findByEleve(eleve);
        int sommeCoef = 0;
        Long sommeMoyenne = Long.valueOf(0);
        Long moyenneGeneral = Long.valueOf(0);
        for (Note note: notes) {
            sommeCoef += note.getMatiere().getCoef();
            sommeMoyenne += note.getMoyX();
        }
        moyenneGeneral = sommeMoyenne/sommeCoef;
        bulletin.setNotes(notes);
        bulletin.setSommeCoef(sommeCoef);
        bulletin.setMoyenneGeneral(moyenneGeneral);
        bulletin.setSommeMoyenne(sommeMoyenne);
        return bulletin;
    }

    public List<Note> getNoteByMatiere(Matiere matiere){
        return noteRepository.findByMatiere(matiere);
    }

    public String deleteNote(Long id){
        noteRepository.deleteById(id);
        return "Note supprimer avec succes !";
    }


}
