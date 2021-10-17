package co.edu.usa.backend.Interface;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.backend.model.Reservation;

public interface ReservationInterface extends CrudRepository<Reservation,Integer>{
    
}
