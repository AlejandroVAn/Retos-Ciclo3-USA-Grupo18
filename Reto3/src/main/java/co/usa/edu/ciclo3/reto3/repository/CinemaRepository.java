package co.usa.edu.ciclo3.reto3.repository;


import co.usa.edu.ciclo3.reto3.model.Cinema;
import co.usa.edu.ciclo3.reto3.repository.crud.CinemaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CinemaRepository {

    @Autowired
    private CinemaCrudRepository cinemaCrudRepository;
    public List<Cinema> getAll(){
        return (List<Cinema>) cinemaCrudRepository.findAll();
    }
    public Optional<Cinema> getCinema(int id){
        return cinemaCrudRepository.findById(id);
    }
    public Cinema save(Cinema c){
        return cinemaCrudRepository.save(c);
    }
    public void delete(Cinema c){cinemaCrudRepository.delete(c);}
}

