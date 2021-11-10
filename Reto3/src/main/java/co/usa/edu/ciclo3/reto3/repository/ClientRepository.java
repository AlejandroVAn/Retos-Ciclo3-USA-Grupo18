package co.usa.edu.ciclo3.reto3.repository;


import co.usa.edu.ciclo3.reto3.model.Cinema;
import co.usa.edu.ciclo3.reto3.model.Client;
import co.usa.edu.ciclo3.reto3.model.Message;
import co.usa.edu.ciclo3.reto3.repository.crud.CinemaCrudRepository;
import co.usa.edu.ciclo3.reto3.repository.crud.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }
    public Client save(Client c){
        return clientCrudRepository.save(c);
    }
    public void delete(Client c){clientCrudRepository.delete(c);}

}

