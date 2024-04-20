package ehm.sn.api_note.services;

import ehm.sn.api_note.enties.Bulletin;
import ehm.sn.api_note.enties.Eleve;
import ehm.sn.api_note.enties.Matiere;
import ehm.sn.api_note.enties.Note;
import ehm.sn.api_note.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> notes(){
        return noteRepository.findAll();
    }

    public Note addNote(Note note) {
        Long notes = (note.getNote_1() + note.getNote_2()) / 2;
        Long moyenne = (notes + note.getIntegration()) / 2;
        note.setMoyenne(moyenne);
        note.setMoyX(moyenne * note.getMatiere().getCoef());
        return noteRepository.save(note);
    }

    @Transactional
    public void updateNote(Note note){
        System.out.println("Methode Update" + note);
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
        if (sommeCoef != 0) {
            moyenneGeneral = sommeMoyenne / sommeCoef;
        }
        bulletin.setNotes(notes);
        bulletin.setSommeCoef(sommeCoef);
        bulletin.setMoyenneGeneral(moyenneGeneral);
        bulletin.setSommeMoyenne(sommeMoyenne);
        return bulletin;
    }

    public List<Note> getNoteByMatiere(Matiere matiere){
        return noteRepository.findByMatiere(matiere);
    }

    public void deleteNote(Long id){
        noteRepository.deleteById(id);
    }



}
