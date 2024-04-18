package ehm.sn.api_note.repositories;

import ehm.sn.api_note.enties.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Long> {

}
