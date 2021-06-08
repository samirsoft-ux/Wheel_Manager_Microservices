package pe.edu.upc.producto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.producto.entities.Vehicle;
import pe.edu.upc.producto.services.VehicleService;

import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vehicle> fetchById(@PathVariable("id") Long id){
        try {
            Optional<Vehicle> optionalVehicle = vehicleService.findById(id);
            if (optionalVehicle.isPresent()){
                return new ResponseEntity<Vehicle>(optionalVehicle.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //vehicleName
    @GetMapping(path = "/vehicleName/{vehicleName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vehicle> fetchByVehicleName(@PathVariable("vehicleName") String name){
        try {
            Optional<Vehicle> optionalVehicle = vehicleService.findByVehicleName(name);
            if (optionalVehicle.isPresent()){
                return new ResponseEntity<Vehicle>(optionalVehicle.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //calification
    @GetMapping(path = "/calification/{calification}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vehicle> fetchByCalification(@PathVariable("calification") Integer calification){
        try {
            Optional<Vehicle> optionalVehicle = vehicleService.findByCalification(calification);
            if (optionalVehicle.isPresent()){
                return new ResponseEntity<Vehicle>(optionalVehicle.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
