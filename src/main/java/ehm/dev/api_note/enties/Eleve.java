package ehm.dev.api_note.enties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Eleve {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Date dateN;
    private String sexe;
    private String image;

    @OneToMany(mappedBy = "eleve", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Note> notes;


}
