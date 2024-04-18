package ehm.sn.api_note.enties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bulletin {

    private List<Note> notes;
    private int sommeCoef;
    private Long sommeMoyenne;
    private Long moyenneGeneral;


}
