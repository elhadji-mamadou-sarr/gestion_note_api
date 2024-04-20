package ehm.sn.api_note.services;

import ehm.sn.api_note.enties.Matiere;
import ehm.sn.api_note.repositories.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void updateMatiere(Matiere matiere){
        Optional<Matiere> optionalMatiere = matiereRepository.findById(matiere.getId());
        if (optionalMatiere.isPresent()) {
            Matiere existantMatiere = optionalMatiere.get();
            existantMatiere.setNom(matiere.getNom());
            //existantMatiere.setNotes(matiere.getNotes());
            existantMatiere.setCoef(matiere.getCoef());
            matiereRepository.save(existantMatiere);
        }else
            throw new RuntimeException("Matiere introuvable");
    }

    public void deleteMatiere(Long id){
        matiereRepository.deleteById(id);
    }
}
