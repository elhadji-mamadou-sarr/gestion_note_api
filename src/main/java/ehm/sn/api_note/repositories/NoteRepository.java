package ehm.sn.api_note.repositories;

import ehm.sn.api_note.enties.Eleve;
import ehm.sn.api_note.enties.Matiere;
import ehm.sn.api_note.enties.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("SELECT n FROM Note n WHERE n.eleve = :eleve")
    List<Note> findByEleve(Eleve eleve);

    @Query("SELECT n FROM Note n where n.matiere=:matiere")
    List<Note> findByMatiere(Matiere matiere);


}
