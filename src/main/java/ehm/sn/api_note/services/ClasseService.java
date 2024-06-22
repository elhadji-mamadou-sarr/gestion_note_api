package ehm.sn.api_note.services;


import ehm.sn.api_note.enties.Classe;
import ehm.sn.api_note.repositories.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    public List<Classe> findAllClasse(){
        return classeRepository.findAll();
    }

}
