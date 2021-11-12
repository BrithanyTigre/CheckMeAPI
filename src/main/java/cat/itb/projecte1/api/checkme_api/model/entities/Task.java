package cat.itb.projecte1.api.checkme_api.model.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Entity
public class Task implements Serializable {
    @Id
    private String idTask;
    @ManyToOne()
    @JoinColumn
    private TasksList idTasksList;
    private String name;
    private boolean done;

}
