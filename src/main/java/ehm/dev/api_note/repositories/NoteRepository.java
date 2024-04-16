package ehm.dev.api_note.repositories;

import ehm.dev.api_note.enties.Eleve;
import ehm.dev.api_note.enties.Matiere;
import ehm.dev.api_note.enties.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("SELECT n FROM Note n WHERE n.eleve = :eleve")
    List<Note> findByEleve(Eleve eleve);

    @Query("SELECT n FROM Note n where n.matiere=:matiere")
    List<Note> findByMatiere(Matiere matiere);
}
