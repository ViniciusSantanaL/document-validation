package br.com.sicredi.documentvalidation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Random;

@Service
public class DocumentValidationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DocumentValidationService.class);
    public Optional<Boolean> validationCPF(String documentNumber) {
        Optional<Boolean> result = Optional.empty();

        boolean isValid = this.isCPF(documentNumber);
        if(!isValid) {
            LOGGER.error(messageWithWordOrNot(false)+  "valid: " + documentNumber );
            return result;
        }

        LOGGER.info(messageWithWordOrNot(true)+  "valid: " + documentNumber );

        result = Optional.of(this.isRegularCPF());

        LOGGER.info(messageWithWordOrNot(result.get())+  "regular: " + documentNumber );

        return result;
    }

    private boolean isCPF(String CPF) {

        if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
            || CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") || CPF.equals("66666666666")
                || CPF.equals("77777777777") || CPF.equals("88888888888") || CPF.equals("99999999999") || (CPF.length() != 11))
            return false;

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {

            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = CPF.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48);

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = CPF.charAt(i) - 48;
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            return (dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10));
        } catch (InputMismatchException ex) {
            return false;
        }
    }

    private boolean isRegularCPF() {
        Random random = new Random();
        return random.nextInt(11) <= 5;
    }

    private String messageWithWordOrNot(boolean hasNotWord) {
        return hasNotWord ? "cpf is " : "cpf is not ";
    }
}
