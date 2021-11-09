package cat.itb.projecte1.api.checkme_api.model.entities;

import lombok.Data;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@Entity
public class List {
    @Id
    private String idList;
    private String name;
    private String filter;

    /*@OneToMany(mappedBy = "List", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;*/

}
