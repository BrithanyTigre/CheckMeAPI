package cat.itb.projecte1.api.checkme_api.model.entities;

import lombok.Data;
import lombok.Generated;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class TList {
    @Id
    @Generated
    private String idList;
    private String name;
    private String filter;
}
