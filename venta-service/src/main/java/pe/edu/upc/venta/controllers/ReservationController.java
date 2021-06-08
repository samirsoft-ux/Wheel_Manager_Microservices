package pe.edu.upc.venta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.venta.entities.Reservation;
import pe.edu.upc.venta.services.ReservationService;

import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    //para id
    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> fetchById(@PathVariable("id") Long id){
        try {
            Optional<Reservation> optionalReservation = reservationService.findById(id);
            if (optionalReservation.isPresent()){
                return new ResponseEntity<Reservation>(optionalReservation.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //para price
    @GetMapping(path = "/price/{price}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Reservation> fetchByPrice(@PathVariable("price") Double price){
        try {
            Optional<Reservation> optionalReservation = reservationService.findByPrice(price);
            if (optionalReservation.isPresent()){
                return new ResponseEntity<Reservation>(optionalReservation.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
