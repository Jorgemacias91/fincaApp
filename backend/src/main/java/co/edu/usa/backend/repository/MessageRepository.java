package co.edu.usa.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.backend.Interface.MessageInterface;
import co.edu.usa.backend.model.Message;

@Repository
public class MessageRepository {
    
    @Autowired
    private MessageInterface crud;

    public List<Message> getAll(){
        return (List<Message>) crud.findAll();
    }

    public Optional<Message> getMessage(int id){
        return crud.findById(id);
    }

    public Message save(Message message){
        return crud.save(message);
    }

    public void delete(Message message){
        crud.delete(message);
    }

}
