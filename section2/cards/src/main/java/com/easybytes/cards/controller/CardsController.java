package com.easybytes.cards.controller;

import com.easybytes.cards.dto.CardsDto;
import com.easybytes.cards.dto.ResponseDto;
import com.easybytes.cards.service.IcardsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
public class CardsController {

    @Autowired
    private IcardsService cardsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto>createCards(@Valid @RequestParam
                                                      @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                      String mobileNumber){
        cardsService.createCards(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(HttpStatus.CREATED.name(),"Card created successfully"));

    }

    @GetMapping("/fetch")
    public ResponseEntity<CardsDto>fetchCards(@Valid @RequestParam
                                                       @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                       String mobileNumber){
        CardsDto  cardsDto =cardsService.fetchCards(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(cardsDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto>updateCards(@Valid @RequestBody CardsDto cardsDto){
        boolean isUpadated = cardsService.updateCards(cardsDto);
        if(isUpadated){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.name(),"Card updated successfully"));
        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(HttpStatus.EXPECTATION_FAILED.name(),"Card not found"));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto>deleteCards(@Valid @RequestParam
                                                       @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                       String mobileNumber){
        boolean isDeleted = cardsService.deleteCards(mobileNumber);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(HttpStatus.OK.name(),"Card deleted successfully"));
        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(HttpStatus.EXPECTATION_FAILED.name(),"Card not found"));
        }
    }
}
