package com.commerce.bikes.service.impl;

import com.commerce.bikes.apis.dtos.responses.responses.StandardResponseDTO;
import com.commerce.bikes.exceptions.ObjectNotFoundException;
import com.commerce.bikes.exceptions.SaveMethodException;
import com.commerce.bikes.repository.IBikeRepository;
import com.commerce.bikes.repository.entities.Bike;
import com.commerce.bikes.service.interfaces.IBikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BikeService implements IBikeService {

    @Autowired
    private IBikeRepository bikeRepository;

    @Override
    public Bike findBikeById(String bikeId) throws ObjectNotFoundException {
        log.info("initialized find");
        var bikeFind = bikeRepository.findById(bikeId);
        if (bikeFind.isPresent()) {
            return bikeFind.get();
        } else {
            throw new ObjectNotFoundException("E01", "equipment not found");
        }
    }

    @Override
    public Bike save(Bike bike) throws SaveMethodException, ObjectNotFoundException {
        log.info("initialized equipmentService.save");
        if (bike != null) {
            log.info("processing save");
            bikeRepository.save(bike);
            log.info("save complete");
            return bike;
        } else {
            log.error("validation failed");
            throw new SaveMethodException("E01", "Invalid equipment entered");
        }
    }

    @Override
    public StandardResponseDTO delete(Bike bike) throws ObjectNotFoundException {
        log.info("initialized equipmentService.delete");
        var equipmentDelete = bikeRepository.findById(
                bike.getId());
        if (equipmentDelete.isEmpty()) {return StandardResponseDTO.builder()
                .code(HttpStatus.NO_CONTENT.value()).message("bike not found").build();}
        log.info("processing delete");
        bikeRepository.delete(equipmentDelete.get());
        log.info("delete completed");

        return bikeRepository.existsById(bike.getId()) ? StandardResponseDTO.builder()
                .code(HttpStatus.NOT_ACCEPTABLE.value()).message("not possible to execute delete").build()
                : StandardResponseDTO.builder().code(HttpStatus.OK.value())
                .message("bike successfully deleted").build();
    }

    @Override
    public List<Bike> listAllBikse() {
        return null;
    }


    @Override
    public List<Bike> listAllBikes() {

        log.info("initialized BikeService.listAll");
        log.info("listAll completed");
        return bikeRepository.findAll();
    }

    @Override
    public Bike update(Bike bike) throws ObjectNotFoundException {


        log.info("initialized EquipmentService.update");
        var bikeFind = bikeRepository.findById(bike.getId())
                .orElseThrow(() -> new ObjectNotFoundException("E01", "Equipment not found")
                );
        log.info("processing update");
        bikeFind.setName(bike.getName());
        bikeFind.setType(bike.getType());
        bikeFind.setPrice(bike.getPrice());

        log.info("update complete");

        return bikeRepository.save(bikeFind);
    }

    public StandardResponseDTO bikeSale(String bikeId, String customerId) {
        var bikeFound = bikeRepository.findById(bikeId);
        if (bikeFound.isPresent()) {
            bikeFound.get().setOwner(customerId);
            bikeRepository.save(bikeFound.get());

            return StandardResponseDTO.builder()
                    .code(HttpStatus.OK.value())
                    .message("compra realizada com sucesso")
                    .build();
        }
        return StandardResponseDTO.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("produto não encontrado")
                .build();
    }

}


