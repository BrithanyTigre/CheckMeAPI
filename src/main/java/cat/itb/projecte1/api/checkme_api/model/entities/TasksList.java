package cat.itb.projecte1.api.checkme_api.model.entities;

import lombok.Data;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Entity
public class TasksList {
    @Id
    private String idList;
    private String name;
    private String filter;
    @OneToMany(mappedBy = "idList", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Task> tasks;

}
