package cat.itb.projecte1.api.checkme_api.model.entities;

import lombok.Data;
import javax.persistence.*;


@Data
@Entity
public class TList {
    @Id
    @GeneratedValue
    private Long idList;
    private String name;
    private String filter;
}
