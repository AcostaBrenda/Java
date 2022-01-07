package com.medicalClinic.service;

import com.medicalClinic.model.Address;
import com.medicalClinic.repository.IAddressRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    //va a tener actualizar a traves del service de paciente y doctor, buscando la direccion asociada con su dni
    // borrar una direccion cuando se borra un paciente o doctor en cada service

    @Autowired
    private IAddressRepository addressRepository;

    static final Logger logger = Logger.getLogger(AddressService.class);


    public Address saveAddress(Address address) {

        logger.info("address uploaded" + address);

        if(address == null) throw new IllegalArgumentException("the address entered contains no data");

        return addressRepository.save(address);
    }


    public Boolean deleteAddress(Address address) {

        logger.info("address before deleting" + address);

        if(addressRepository.findById(address.getId()).isPresent()){

            addressRepository.delete(address);

        return addressRepository.findById(address.getId()).isPresent();

        }else throw new IllegalArgumentException("The address entered is not in the database");
    }
}