package sbcpfapi.verificadorcpf.domain.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(of={"cpf"})
public class ValidadorCPFResponse {
    private String cpf;
    private String status;
    private boolean valid;
    private String digitos;

    public ValidadorCPFResponse(String cpf){
        this.cpf = cpf;
    }


}
