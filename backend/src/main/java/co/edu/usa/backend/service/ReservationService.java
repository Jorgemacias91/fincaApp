package co.edu.usa.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.backend.model.Reservation;
import co.edu.usa.backend.repository.ReservationRepository;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository metCrud;

    public List<Reservation> getAll(){
        return metCrud.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return metCrud.getReservation(reservationId);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return metCrud.save(reservation);
        }else{
            Optional<Reservation> e= metCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= metCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean delete(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
