package br.com.sicredi.documentvalidation.dto;

import java.io.Serializable;

public class DocumentValidationOutputDTO implements Serializable {

    private DocumentValidationStatus status;

    public DocumentValidationOutputDTO(DocumentValidationStatus status) {
        this.status = status;
    }

    public DocumentValidationStatus getStatus() {
        return status;
    }

    public void setStatus(DocumentValidationStatus status) {
        this.status = status;
    }
}
