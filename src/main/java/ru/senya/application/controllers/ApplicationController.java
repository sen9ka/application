package ru.senya.application.controllers;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.senya.application.entity.dto.LoanApplicationRequestDTO;
import ru.senya.application.entity.dto.LoanOfferDTO;
import ru.senya.application.services.ApplicationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/application")
public class ApplicationController {

    @Value("${applicationLink}")
    private String applicationsUrl;

    @Value("${offersLink}")
    private String offersUrl;

    private final ApplicationService applicationService;

    Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    @PostMapping("/")
    public ResponseEntity<?> getLoanOffers(@RequestBody LoanApplicationRequestDTO loanApplicationRequestDTO) {
        logger.trace("Application API accessed");
        List<LoanOfferDTO> loanOfferDTOList = applicationService.makePostRequestToApplication(loanApplicationRequestDTO, applicationsUrl);
        return new ResponseEntity<>(loanOfferDTOList, HttpStatus.OK);
    }

    @PostMapping("/offer")
    public ResponseEntity<?> getLoanOffers(@RequestBody LoanOfferDTO loanOfferDTO) {
        logger.trace("Offers API accessed");
        return applicationService.makePostRequestToOffer(loanOfferDTO, offersUrl);
    }

}
