package ehm.dev.api_note.enties;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Matiere {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private int coef;

    @OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Note> notes;


}
