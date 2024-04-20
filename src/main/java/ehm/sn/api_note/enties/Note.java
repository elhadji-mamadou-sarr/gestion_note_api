package ehm.sn.api_note.enties;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data @Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
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
