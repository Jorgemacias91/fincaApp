package co.edu.usa.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.backend.Interface.ReservationInterface;
import co.edu.usa.backend.model.Reservation;

@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationInterface crud;

    public List<Reservation> getAll(){
        return (List<Reservation>) crud.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return crud.findById(id);
    }

    public Reservation save(Reservation reservation){
        return crud.save(reservation);
    }

    public void delete(Reservation reservation){
        crud.delete(reservation);
    }
}
