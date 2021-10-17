package co.edu.usa.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.backend.model.Farm;
import co.edu.usa.backend.repository.FarmRepository;

@Service
public class FarmService {
    
    @Autowired
    private FarmRepository metCrud;
    
    public List<Farm> getAll(){
       return metCrud.getAll();
   }
   public Optional<Farm> getFarm(int idFarm) {
       return metCrud.getFarm(idFarm);
   }

   public Farm save(Farm farm){
       if(farm.getId()==null){
           return metCrud.save(farm);
       }else{
           Optional<Farm> e=metCrud.getFarm(farm.getId());
           if(e.isEmpty()){
               return metCrud.save(farm);
           }else{
               return farm;
           }
       }
   }
    public Farm update(Farm farm){
       if(farm.getId()!=null){
           Optional<Farm> e=metCrud.getFarm(farm.getId());
           if(!e.isEmpty()){
               if(farm.getAddress()!=null){
                   e.get().setAddress(farm.getAddress());
               }
               if(farm.getExtension()!=null){
                   e.get().setExtension(farm.getExtension());
               }
               if(farm.getDescription()!=null){
                   e.get().setDescription(farm.getDescription());
               }
               if(farm.getName()!=null){
                   e.get().setName(farm.getName());
               }
               if(farm.getCategory()!=null){
                   e.get().setCategory(farm.getCategory());
               }
               metCrud.save(e.get());
               return e.get();
           }else{
               return farm;
           }
       }else{
           return farm;
       }
   }


   public boolean delete(int farmId) {
       Boolean aBoolean = getFarm(farmId).map(farm -> {
           metCrud.delete(farm);
           return true;
       }).orElse(false);
       return aBoolean;
   }
}
