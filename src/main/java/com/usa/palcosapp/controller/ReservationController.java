package com.usa.palcosapp.controller;

import com.usa.palcosapp.model.ClientReport;
import com.usa.palcosapp.model.Reservation;
import com.usa.palcosapp.model.ReservationReport;
import com.usa.palcosapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Reservation")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @GetMapping("{idReservation}")
    public Optional<Reservation> getById(@PathVariable("idReservation") Integer id){
        return reservationService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return reservationService.delete(id);
    }

    @GetMapping("report-status")
    public ReservationReport getReservationStatusReport(){
        return reservationService.getReservationStatusReport();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationReportDates(@PathVariable("dateOne")Date dateOne, @PathVariable("dateTwo")Date dateTwo){
        return getReservationReportDates(dateOne,dateTwo);
    }

    @GetMapping("/report-clients")
    public List<ClientReport> getReportClients(){
        return reservationService.getTopClient();
        }
}
