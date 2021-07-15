package com.dev.springlocationapi.service;

import com.dev.springlocationapi.domain.Address;
import com.dev.springlocationapi.repository.AddressRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses(){
         return addressRepository.findAll();
    }

    public Address getAddressByID(Long id){
        return addressRepository.getById(id);
    }

    public void saveAddress(Address address){
        addressRepository.save(address);
    }

    public void updateAddressById(Long id, Address address){

        Address existAddress = getAddressByID(id);

        if(existAddress == null){
            throw new NoSuchElementException("Address with id" +  id + " does not found!");
        }

        existAddress.setCountry(address.getCountry());
        existAddress.setCountryCode(address.getCountryCode());
        existAddress.setCity(address.getCity());
        existAddress.setDistrict(address.getDistrict());
        existAddress.setStreet(address.getStreet());

        addressRepository.save(existAddress);
    }

    public void deleteAddressById(Long id){
        addressRepository.deleteById(id);
    }
}
