package co.usa.edu.ciclo3.reto3.repository.crud;

import co.usa.edu.ciclo3.reto3.model.Client;
import co.usa.edu.ciclo3.reto3.model.Score;
import org.springframework.data.repository.CrudRepository;

public interface ScoreCrudRepository extends CrudRepository<Score, Integer> {
}
