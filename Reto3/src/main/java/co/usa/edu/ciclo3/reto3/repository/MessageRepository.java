package co.usa.edu.ciclo3.reto3.repository;


import co.usa.edu.ciclo3.reto3.model.Cinema;
import co.usa.edu.ciclo3.reto3.model.Message;
import co.usa.edu.ciclo3.reto3.repository.crud.CinemaCrudRepository;
import co.usa.edu.ciclo3.reto3.repository.crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    public Message save(Message m){
        return messageCrudRepository.save(m);
    }
    public void delete(Message m){messageCrudRepository.delete(m);}
}

