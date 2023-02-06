package ru.senya.application.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.senya.application.clients.DealClient;
import ru.senya.application.entity.dto.LoanApplicationRequestDTO;
import ru.senya.application.entity.dto.LoanOfferDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final DealClient dealClient;

    public List<LoanOfferDTO> makePostRequestToApplication(LoanApplicationRequestDTO loanApplicationRequestDTO, String applicationUrl) {

        return dealClient.createPostRequestToApplication(loanApplicationRequestDTO, applicationUrl);

    }

    public ResponseEntity<?> makePostRequestToOffer(LoanOfferDTO loanOfferDTO, String offersUrl) {

        return dealClient.createPostRequestToOffer(loanOfferDTO, offersUrl);

    }

}
