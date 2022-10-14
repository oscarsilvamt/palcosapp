package com.usa.palcosapp.service;

import com.usa.palcosapp.model.Reservation;
import com.usa.palcosapp.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getById(Integer id){
        return reservationRepository.getById(id);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> optional= reservationRepository.getById(reservation.getIdReservation());
            if(optional.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> optional=reservationRepository.getById(reservation.getIdReservation());
            if(!optional.isEmpty()){
                if(reservation.getStartDate()!=null){
                    optional.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    optional.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    optional.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(optional.get());
                return optional.get();
            }else{
                return reservation;
            }
        }else {
            return reservation;
        }
    }

    public boolean delete (Integer id){
        Boolean aBoolean=getById(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return false;
    }
}
