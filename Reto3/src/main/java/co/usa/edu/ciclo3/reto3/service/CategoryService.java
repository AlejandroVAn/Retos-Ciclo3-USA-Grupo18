package co.usa.edu.ciclo3.reto3.service;

import co.usa.edu.ciclo3.reto3.model.Category;
import co.usa.edu.ciclo3.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    public Optional<Category> getCategoryId(int id){
        return categoryRepository.getCategory(id);
    }
    public Category save(Category c){
        if (c.getIdCategory()==null){
            return categoryRepository.save(c);
        }else{
            Optional<Category> paux=categoryRepository.getCategory(c.getIdCategory());
            if(paux.isEmpty()){
                return categoryRepository.save(c);
            }else{
                return c;
            }
        }
    }
    public Category update(Category c){
        if(c.getIdCategory()!=null){
            Optional<Category>g= categoryRepository.getCategory(c.getIdCategory());
            if(!g.isEmpty()){
                if(c.getDescription()!=null){
                    g.get().setDescription(c.getDescription());
                }
                if(c.getName()!=null){
                    g.get().setName(c.getName());
                }
                return categoryRepository.save(g.get());
            }
        }
        return c;
    }
    public boolean deleteCategory(int categoryId){
        Boolean d=getCategoryId(categoryId).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return d;
    }

}
