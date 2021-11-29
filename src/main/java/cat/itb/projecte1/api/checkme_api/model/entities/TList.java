package cat.itb.projecte1.api.checkme_api.model.entities;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class TList {
    @Id
    @GeneratedValue
    private Long idList;
    private String name;
    private String filter;
}
