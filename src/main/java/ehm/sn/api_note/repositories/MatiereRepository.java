package ehm.sn.api_note.repositories;


import ehm.sn.api_note.enties.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Long> {
}
