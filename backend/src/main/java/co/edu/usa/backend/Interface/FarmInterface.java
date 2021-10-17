package co.edu.usa.backend.Interface;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.backend.model.Farm;

public interface FarmInterface extends CrudRepository<Farm,Integer>{
    
}
