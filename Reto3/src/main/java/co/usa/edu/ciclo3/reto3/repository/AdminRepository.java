package co.usa.edu.ciclo3.reto3.repository;


import co.usa.edu.ciclo3.reto3.model.Admin;
import co.usa.edu.ciclo3.reto3.model.Cinema;
import co.usa.edu.ciclo3.reto3.repository.crud.AdminCrudRepository;
import co.usa.edu.ciclo3.reto3.repository.crud.CinemaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository adminCrudRepository;
    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }
    public Optional<Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
    public Admin save(Admin a){
        return adminCrudRepository.save(a);
    }
    public void delete(Admin a){adminCrudRepository.delete(a);}
}

