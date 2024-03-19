package sbcpfapi.verificadorcpf.domain.service;

import org.springframework.stereotype.Service;
import sbcpfapi.verificadorcpf.domain.model.ValidadorCPFResponse;

@Service
public class ValidadorCPFService {
    public ValidadorCPFResponse validar(String cpf) {
        ValidadorCPFResponse response = new ValidadorCPFResponse(cpf);
        //494001138 03
        //String a = cpf.substring(0,1);
        //int b = Integer.parseInt(a);
        int primeiroDigitoValido = 0;
        int segundoDigitoValido = 0;
        int contador = 10;
        int somaDigito1 = 0;
        int somaDigito2 = 0;
        somaDigito1 = percorrerCPF(cpf, contador);
        somaDigito1 = calcularResto(somaDigito1);
        primeiroDigitoValido = testeDigito(somaDigito1);

        contador = 11;

        somaDigito2 = percorrerCPF(cpf, contador);
        somaDigito2 += (primeiroDigitoValido * 2);
        somaDigito2 = calcularResto(somaDigito2);
        segundoDigitoValido = testeDigito(somaDigito2);

        boolean validar = (primeiroDigitoValido == Integer.parseInt(cpf.substring(9,10))) && (segundoDigitoValido ==
                Integer.parseInt(cpf.substring(10,11)));
        response.setValid(validar);
        response.setStatus(validar ? "CPF válido" : "CPF inválido");
        if (!validar) {
            response.setDigitos(String.valueOf(primeiroDigitoValido) + segundoDigitoValido);
        }
        return response;
    }
        public int percorrerCPF(String cpf, int contador){
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                String numeroCPF = cpf.substring(i, i + 1);
                int digitoUnico = Integer.parseInt(numeroCPF);
                soma += (digitoUnico * contador);
                contador--;
            }
            return soma;
        }

        public int calcularResto(int numero){
            int resto = numero % 11;
            return resto;
        }

        public int testeDigito(int restocpf){
            int digito = 0;
            if (restocpf < 2) {
                digito = 0;
            } else {
                digito = 11 - restocpf;
            }
            return digito;
        }
}
