package co.edu.usa.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.backend.model.Client;
import co.edu.usa.backend.repository.ClientRepository;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository metCrud;
    
    public List<Client> getAll(){
       return metCrud.getAll();
   }
    
     public Optional<Client> getClient(int clientId) {
       return metCrud.getClient(clientId);
   }

   public Client save(Client client){
       if(client.getIdClient()==null){
           return metCrud.save(client);
       }else{
           Optional<Client> e= metCrud.getClient(client.getIdClient());
           if(e.isEmpty()){
               return metCrud.save(client);
           }else{
               return client;
           }
       }
   }

   public Client update(Client client){
       if(client.getIdClient()!=null){
           Optional<Client> e= metCrud.getClient(client.getIdClient());
           if(!e.isEmpty()){
               if(client.getName()!=null){
                   e.get().setName(client.getName());
               }
               if(client.getEmail()!=null){
                   e.get().setEmail(client.getEmail());
               }
               if(client.getPassword()!=null){
                   e.get().setPassword(client.getPassword());
               }
               if(client.getAge()!=null){
                   e.get().setAge(client.getAge());
               }
               metCrud.save(e.get());
               return e.get();
           }else{
               return client;
           }
       }else{
           return client;
       }
   }

   public boolean delete(int id) {
       Boolean aBoolean = getClient(id).map(client -> {
           metCrud.delete(client);
           return true;
       }).orElse(false);
       return aBoolean;
   }
}
