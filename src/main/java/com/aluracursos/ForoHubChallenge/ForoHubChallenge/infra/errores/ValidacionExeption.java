package com.aluracursos.ForoHubChallenge.ForoHubChallenge.infra.errores;

public class ValidacionExeption extends RuntimeException {
    public ValidacionExeption(String mensaje) {
        super(mensaje);
    }
}