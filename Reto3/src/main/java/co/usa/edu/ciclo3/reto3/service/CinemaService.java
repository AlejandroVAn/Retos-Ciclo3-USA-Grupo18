package co.usa.edu.ciclo3.reto3.service;

import co.usa.edu.ciclo3.reto3.model.Cinema;
import co.usa.edu.ciclo3.reto3.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAll(){
        return cinemaRepository.getAll();
    }
    public Optional<Cinema> getCinemaId(int id){
        return cinemaRepository.getCinema(id);
    }
    public Cinema save(Cinema c){
        if (c.getId()==null){
            return cinemaRepository.save(c);
        }else{
            Optional<Cinema> paux=cinemaRepository.getCinema(c.getId());
            if(paux.isEmpty()){
                return cinemaRepository.save(c);
            }else{
                return c;
            }
        }
    }
}
