package com.commerce.bikes.apis.api;

import com.commerce.bikes.adapters.BikeAdapter;
import com.commerce.bikes.adapters.BikeDTOAdapter;
import com.commerce.bikes.apis.dtos.requests.BikeDTO;
import com.commerce.bikes.apis.dtos.responses.responses.BikeListResponseDTO;
import com.commerce.bikes.apis.dtos.responses.responses.BikeResponseDTO;
import com.commerce.bikes.apis.dtos.responses.responses.DeleteResponseDTO;
import com.commerce.bikes.apis.dtos.responses.responses.StandardResponseDTO;
import com.commerce.bikes.exceptions.ObjectNotFoundException;
import com.commerce.bikes.exceptions.SaveMethodException;
import com.commerce.bikes.repository.entities.Bike;
import com.commerce.bikes.service.interfaces.IBikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/V1/Bike")
public class BikeAPI {

    @Autowired
    private IBikeService bikeService;

    @PostMapping("/new")
    public BikeResponseDTO addWithBody(@RequestBody BikeDTO equipmentDTO)
            throws SaveMethodException, ObjectNotFoundException {
        return BikeResponseDTO.builder()
                .data(
                        BikeDTOAdapter.convertTo(
                                bikeService.save(BikeAdapter.convertTo(equipmentDTO))
                        )
                )
                .build();
    }

    @GetMapping("/find/{bike}")
    public BikeResponseDTO find(@PathVariable("bike") String bikeNumber)
            throws ObjectNotFoundException {
        return BikeResponseDTO.builder()
                .data(
                        BikeDTOAdapter.convertTo(
                                bikeService.findBikeById(bikeNumber)
                        )
                )
                .build();
    }

    @GetMapping("/bikeList")
    public BikeListResponseDTO listAllBikes() {
        return BikeListResponseDTO.builder()
                .data(
                        BikeDTOAdapter.convertToList(
                                bikeService.listAllBikes()
                        )
                )
                .build();
    }

    @PutMapping("/change")
    public BikeResponseDTO changeWithBody(@RequestBody BikeDTO bikeDTO)
            throws ObjectNotFoundException {
        return BikeResponseDTO.builder()
                .data(
                        BikeDTOAdapter.convertTo(
                                bikeService.update(
                                        BikeAdapter.convertTo(bikeDTO)
                                )
                        )
                ).build();
    }

    @DeleteMapping("/delete/{bikeId}")
    public ResponseEntity<StandardResponseDTO> delete(@PathVariable("bikeId") String bikeId)
            throws ObjectNotFoundException {
        var deletedBike = bikeService.delete(Bike.builder().id(bikeId).build());

        return ResponseEntity.status(deletedBike.getCode()).body(deletedBike);
    }

    @PostMapping("/purchase/{bikeId}/{customerId}")
    public ResponseEntity<StandardResponseDTO> bikePurchase(@PathVariable("bikeId") String bikeId,
                                                            @PathVariable("customerId") String customerId) {
        var bikeSold = bikeService.bikeSale(bikeId, customerId);

        return ResponseEntity.status(bikeSold.getCode()).body(bikeSold);

    }
}
