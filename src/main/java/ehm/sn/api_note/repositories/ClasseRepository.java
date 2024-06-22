package ehm.sn.api_note.repositories;

import ehm.sn.api_note.enties.Classe;
import ehm.sn.api_note.enties.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {

    @Query("SELECT c FROM Classe c WHERE c.classe = :classe")
    List<Eleve> findEleveByClasse(Classe classe);

}
