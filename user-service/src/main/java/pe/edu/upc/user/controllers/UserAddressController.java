package pe.edu.upc.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.user.entities.UserAddress;
import pe.edu.upc.user.services.UserAddressService;

import java.util.Optional;

@RestController
@RequestMapping("/user_addresses")
public class UserAddressController {
    @Autowired
    private UserAddressService userAddressService;

    @GetMapping(path = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAddress> fetchById(@PathVariable("id") Long id){
        try {
            Optional<UserAddress> optionalUserAddress = userAddressService.findById(id);
            if (optionalUserAddress.isPresent()){
                return new ResponseEntity<UserAddress>(optionalUserAddress.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
