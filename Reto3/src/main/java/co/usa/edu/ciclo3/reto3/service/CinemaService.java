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
    public Cinema update(Cinema c){
        if(c.getId()!=null){
            Optional<Cinema> e=cinemaRepository.getCinema(c.getId());
            if(!e.isEmpty()){
                if(c.getName()!=null){
                    e.get().setName(c.getName());
                }
                if(c.getOwner()!=null){
                    e.get().setOwner(c.getOwner());
                }
                if(c.getCapacity()!=null){
                    e.get().setCapacity(c.getCapacity());
                }
                if(c.getDescription()!=null){
                    e.get().setDescription(c.getDescription());
                }
                if(c.getCategory()!=null){
                    e.get().setCategory(c.getCategory());
                }
                cinemaRepository.save(e.get());
                return e.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }
    public boolean deleteCinema(int cinemaId) {
        Boolean aBoolean = getCinemaId(cinemaId).map(c -> {
            cinemaRepository.delete(c);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
