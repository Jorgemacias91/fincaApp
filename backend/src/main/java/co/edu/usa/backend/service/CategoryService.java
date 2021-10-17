package co.edu.usa.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.backend.model.Category;
import co.edu.usa.backend.repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository metCrud;

    public List<Category> getAll(){
        return metCrud.getAll();
    }

    public Optional<Category> getCategory(int id){
        return metCrud.getCategory(id);
    }

    public Category save(Category category){
        if(category.getId()==null){
            return metCrud.save(category);
        }else{
            Optional<Category> elem = metCrud.getCategory(category.getId());
            if(elem.isEmpty()){
                return metCrud.save(category);
            }else{
                return category;
            }
        }
    }

    public Category update(Category category){
        if(category.getId() != null){
            Optional<Category> elem = metCrud.getCategory(category.getId());
            if(!elem.isEmpty()){
                if(category.getDescription() != null){
                    elem.get().setDescription(category.getDescription());
                }
                if(category.getName() != null){
                    elem.get().setName(category.getName());
                }
                return metCrud.save(elem.get());
            }
        }
        return category;
    }

    public boolean delete(int id){
        Boolean elem = getCategory(id).map(category -> {
            metCrud.delete(category);
            return true;
        }).orElse(false);
        return elem;
    }
}
