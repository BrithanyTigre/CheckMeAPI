package cat.itb.projecte1.api.checkme_api.model.repositories;

import cat.itb.projecte1.api.checkme_api.model.entities.TList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListRepository extends JpaRepository<TList, String> {
}
