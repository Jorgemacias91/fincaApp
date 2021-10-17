package co.edu.usa.backend.Interface;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.backend.model.Client;

public interface ClientInterface extends CrudRepository<Client,Integer>{
    
}
