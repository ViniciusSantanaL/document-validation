package br.com.sicredi.documentvalidation.controller;

import br.com.sicredi.documentvalidation.dto.DocumentValidationOutputDTO;
import br.com.sicredi.documentvalidation.dto.DocumentValidationStatus;
import br.com.sicredi.documentvalidation.service.DocumentValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class DocumentValidationController {

    private final DocumentValidationService service;

    @Autowired
    public DocumentValidationController(DocumentValidationService service) {
        this.service = service;
    }
    @GetMapping("/{cpf_number}")
    public ResponseEntity<DocumentValidationOutputDTO> validationCPF(@PathVariable(value = "cpf_number") String cpfNumber) {
        Optional<Boolean> isValid = service.validationCPF(cpfNumber);

        if(isValid.isEmpty()) return ResponseEntity.notFound().build();

        if(isValid.get()) {
            return ResponseEntity.ok(new DocumentValidationOutputDTO(DocumentValidationStatus.ABLE_TO_VOTE));
        } else {
            return ResponseEntity.ok(new DocumentValidationOutputDTO(DocumentValidationStatus.UNABLE_TO_VOTE));
        }
    }
}
