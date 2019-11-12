package data;

import org.launchcode.models.Cheese;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface CheeseDao extends CrudRepository<Cheese, Integer> {
}
