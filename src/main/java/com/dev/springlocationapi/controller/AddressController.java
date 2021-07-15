package com.dev.springlocationapi.controller;

import com.dev.springlocationapi.domain.Address;
import com.dev.springlocationapi.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping({"","/"})
    public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Long id){
        return addressService.getAddressByID(id);
    }

    @PostMapping({"","/"})
    public void saveAddress(@RequestBody Address address){
        addressService.saveAddress(address);
    }

    @PutMapping("/{id}")
    public void updateAddressById(@RequestBody Address address, @PathVariable Long id){
       addressService.updateAddressById(id, address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddressById(Long id){
        addressService.deleteAddressById(id);
    }
}
