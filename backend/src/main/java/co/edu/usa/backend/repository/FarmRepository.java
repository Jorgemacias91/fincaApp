package co.edu.usa.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.backend.Interface.FarmInterface;
import co.edu.usa.backend.model.Farm;

@Repository
public class FarmRepository {
    
    @Autowired
    private FarmInterface crud;

    public List<Farm> getAll(){
        return (List<Farm>) crud.findAll();
    }

    public Optional<Farm> getFarm(int id){
        return crud.findById(id);
    }

    public Farm save(Farm farm){
        return crud.save(farm);
    }

    public void delete(Farm farm){
        crud.delete(farm);
    }

}
