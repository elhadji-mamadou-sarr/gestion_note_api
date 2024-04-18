package ehm.sn.api_note.services;

import ehm.sn.api_note.enties.Eleve;
import ehm.sn.api_note.repositories.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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


    @Transactional
    public void updateEleve(Eleve updatedEleve) {
        Optional<Eleve> optionalEleve = eleveRepository.findById(updatedEleve.getId());

        if (optionalEleve.isPresent()) {
            Eleve existingEleve = optionalEleve.get();
            existingEleve.setNom(updatedEleve.getNom());
            existingEleve.setPrenom(updatedEleve.getPrenom());
            existingEleve.setDateN(updatedEleve.getDateN());
            existingEleve.setSexe(updatedEleve.getSexe());
            existingEleve.setImage(updatedEleve.getImage());

             eleveRepository.save(existingEleve);
        } else {
            // Lever une exception si l'Eleve n'est pas trouvé
            throw new RuntimeException("Eleve non trouvé avec ID : " + updatedEleve.getId());
        }
    }

    public void deleteEleve(Long id) {
        eleveRepository.deleteById(id);
    }


}
