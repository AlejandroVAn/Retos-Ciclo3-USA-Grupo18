package co.usa.edu.ciclo3.reto3.repository.crud;

import co.usa.edu.ciclo3.reto3.model.Client;
import co.usa.edu.ciclo3.reto3.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
