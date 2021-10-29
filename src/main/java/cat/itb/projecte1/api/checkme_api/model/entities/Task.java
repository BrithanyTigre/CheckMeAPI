package cat.itb.projecte1.api.checkme_api.model.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Task {
    @Id
    private String idTask;
    private String name;
    private String description;
}
