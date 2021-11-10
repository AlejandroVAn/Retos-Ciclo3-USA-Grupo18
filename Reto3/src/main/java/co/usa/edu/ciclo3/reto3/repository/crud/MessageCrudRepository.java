package co.usa.edu.ciclo3.reto3.repository.crud;

import co.usa.edu.ciclo3.reto3.model.Client;
import co.usa.edu.ciclo3.reto3.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
