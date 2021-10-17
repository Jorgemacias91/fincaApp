package co.edu.usa.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.backend.model.Message;
import co.edu.usa.backend.repository.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository metCrud;

    public List<Message> getAll(){
        return metCrud.getAll();
    }

    public Optional<Message> getMessage(int messageId) {
        return metCrud.getMessage(messageId);
    }

    public Message save(Message message){
        if(message.getIdMessage()==null){
            return metCrud.save(message);
        }else{
            Optional<Message> e= metCrud.getMessage(message.getIdMessage());
            if(e.isEmpty()){
                return metCrud.save(message);
            }else{
                return message;
            }
        }
    }

    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> e= metCrud.getMessage(message.getIdMessage());
            if(!e.isEmpty()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                metCrud.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean delete(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metCrud.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
