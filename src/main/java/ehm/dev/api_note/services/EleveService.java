package ehm.dev.api_note.services;

import ehm.dev.api_note.enties.Eleve;
import ehm.dev.api_note.repositories.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EleveService {

    @Autowired
    private EleveRepository eleveRepository;

    public List<Eleve> getEleves(){
        return eleveRepository.findAll();
    }

    public Eleve saveEleve(Eleve eleve){
        return eleveRepository.save(eleve);
    }

    public Eleve getEleveById(Long id){
        Optional<Eleve> optionalEleve = eleveRepository.findById(id);
        return optionalEleve.orElse(null);
    }

    public Eleve updateEleve(Eleve eleve){
        Optional<Eleve> optionalEleve = eleveRepository.findById(eleve.getId());
        if (optionalEleve.isPresent())
            return  eleveRepository.save(optionalEleve.get());
        else
            throw  new RuntimeException("Eleve non trouvé");
    }

    public ResponseEntity<String> deleteEleve(Eleve eleve) {
        Optional<Eleve> optionalEleve = eleveRepository.findById(eleve.getId());
        if (optionalEleve.isPresent()) {
            eleveRepository.delete(eleve);
            return ResponseEntity.ok("Élève supprimé avec succès");
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
