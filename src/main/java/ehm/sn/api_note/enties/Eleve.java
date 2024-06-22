package ehm.sn.api_note.enties;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data @Getter @Setter
public class Eleve {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date dateN;
    private String sexe;
    private String image;

    @OneToMany(mappedBy = "eleve", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Note> notes;

    @ManyToOne
    private Classe classe;


}
