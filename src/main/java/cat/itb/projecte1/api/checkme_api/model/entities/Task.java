package cat.itb.projecte1.api.checkme_api.model.entities;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Entity
public class Task implements Serializable {
    @Id
    @Generated
    private String idTask;
    @ManyToOne()
    @JoinColumn
    private TList idList;
    private String name;
    private boolean done = false;

}
