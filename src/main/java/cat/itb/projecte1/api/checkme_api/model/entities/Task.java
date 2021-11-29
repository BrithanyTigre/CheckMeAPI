package cat.itb.projecte1.api.checkme_api.model.entities;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Task implements Serializable {
    @Id
    @GeneratedValue
    private Long idTask;
    @ManyToOne()
    @JoinColumn
    private TList idList;
    private String name;
    private boolean done = false;

}
