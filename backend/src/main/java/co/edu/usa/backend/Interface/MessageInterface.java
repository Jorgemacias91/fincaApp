package co.edu.usa.backend.Interface;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.backend.model.Message;

public interface MessageInterface extends CrudRepository<Message,Integer>{
    
}
