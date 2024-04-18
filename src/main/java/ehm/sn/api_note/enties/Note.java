package ehm.sn.api_note.enties;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Note {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long note_1;
    private Long note_2;
    private Long integration;
    private Long moyenne;
    private Long moyX;
    @ManyToOne
    private Eleve eleve;
    @ManyToOne
    private Matiere matiere;

}
