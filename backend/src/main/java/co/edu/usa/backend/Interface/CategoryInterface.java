package co.edu.usa.backend.Interface;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.backend.model.Category;

public interface CategoryInterface extends CrudRepository<Category,Integer>{
    
}
