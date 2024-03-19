package sbcpfapi.verificadorcpf.adapter.in.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sbcpfapi.verificadorcpf.domain.model.ValidadorCPFResponse;
import sbcpfapi.verificadorcpf.domain.service.ValidadorCPFService;

@RestController
@RequestMapping("/api/cpf")
public class ValidadorCPFController {
    @Autowired
    private ValidadorCPFService validarCPF;

    @GetMapping(value = {"/{cpf}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ValidadorCPFResponse> validacão(@PathVariable("cpf") String cpf){
        ValidadorCPFResponse response = validarCPF.validar(cpf);
        if (response.isValid()){
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }
}
