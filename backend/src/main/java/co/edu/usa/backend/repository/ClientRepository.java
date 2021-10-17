package co.edu.usa.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.backend.Interface.ClientInterface;
import co.edu.usa.backend.model.Client;

@Repository
public class ClientRepository {
    
    @Autowired
    private ClientInterface crud;

    public List<Client> getAll(){
        return (List<Client>) crud.findAll();
    }

    public Optional<Client> getClient(int id){
        return crud.findById(id);
    }

    public Client save(Client client){
        return crud.save(client);
    }

    public void delete(Client client){
        crud.delete(client);
    }

}
