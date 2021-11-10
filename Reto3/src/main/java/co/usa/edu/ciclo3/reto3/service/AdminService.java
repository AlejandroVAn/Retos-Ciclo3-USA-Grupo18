package co.usa.edu.ciclo3.reto3.service;

import co.usa.edu.ciclo3.reto3.model.Admin;
import co.usa.edu.ciclo3.reto3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int adminId) {
        return adminRepository.getAdmin(adminId);
    }

    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return adminRepository.save(admin);
        } else {
            Optional<Admin> admin1 = adminRepository.getAdmin(admin.getIdAdmin());
            if (admin1.isEmpty()) {
                return adminRepository.save(admin);
            } else {
                return admin;
            }
        }
    }

    public Admin update(Admin admin){
        if(admin.getIdAdmin()!=null){
            Optional<Admin>g= adminRepository.getAdmin(admin.getIdAdmin());
            if(!g.isEmpty()){
                if(admin.getPassword()!=null){
                    g.get().setPassword(admin.getPassword());
                }
                if(admin.getName()!=null){
                    g.get().setName(admin.getName());
                }
                return adminRepository.save(g.get());
            }
        }
        return admin;
    }
    public boolean deleteAdmin(int adminId){
        Boolean d=getAdmin(adminId).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return d;
    }
}

