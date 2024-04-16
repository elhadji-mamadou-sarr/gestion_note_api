package ehm.dev.api_note.services;

import ehm.dev.api_note.enties.Eleve;
import ehm.dev.api_note.enties.Matiere;
import ehm.dev.api_note.repositories.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatiereService {

    @Autowired
    MatiereRepository matiereRepository;

    public List<Matiere> getMatieres(){
        return matiereRepository.findAll();
    }

    public Matiere saveMatiere(Matiere matiere){
        return matiereRepository.save(matiere);
    }

    public Matiere getMatiereById(Long id){
        Optional<Matiere> matiere = matiereRepository.findById(id);
        return matiere.orElse(null);
    }

    public Matiere  updateMatiere(Long id, Matiere updatedMatiere) {
        Matiere existingMatiere = matiereRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matiere non trouvée avec ID : " + id));
        existingMatiere.setNom(updatedMatiere.getNom());
        existingMatiere.setCoef(updatedMatiere.getCoef());
        Matiere savedMatiere = matiereRepository.save(existingMatiere);
        return savedMatiere;
    }

    public String deleteMatiere(Long id){
        Optional<Matiere> optionalMatiere = matiereRepository.findById(id);
        if (optionalMatiere.isPresent()){
            matiereRepository.delete(optionalMatiere.get());
            return "Matiere supprimer avec succes";
        }
        else
            return "Matiere non trouvé";
    }


}
