package com.usa.palcosapp.repository.crudrepository;

import com.usa.palcosapp.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
}
