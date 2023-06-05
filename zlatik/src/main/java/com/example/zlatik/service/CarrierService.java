package com.example.zlatik.service;

import com.example.zlatik.entity.Carrier;
import com.example.zlatik.repository.CarrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrierService {

    @Autowired
    private CarrierRepository carrierRepository;
    @Async
    public List<Carrier> getAll() {
        return carrierRepository.findAll();
    }
    @Async
    public Carrier getById(Long id_carrier) {
        return carrierRepository.findById(id_carrier).orElse(null);
    }
    @Async
    public void create(Carrier carrier) {
        carrierRepository.save(carrier);
    }
    @Async
    public void delete(Long id_carrier) {
        carrierRepository.deleteById(id_carrier);
    }
    @Async
    public void update(Carrier carrier) {
        Carrier carrier1 = getById(carrier.getId());
        carrier1.setCarrierType(carrier.getCarrierType());
        carrier1.setCarrierPublisher(carrier.getCarrierPublisher());
        carrierRepository.save(carrier1);
    }
}