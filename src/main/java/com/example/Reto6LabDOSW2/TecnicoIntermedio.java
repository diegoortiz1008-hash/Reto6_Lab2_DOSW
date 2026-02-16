package com.example.Reto6LabDOSW2;

public class TecnicoIntermedio extends Tecnico {

    public TecnicoIntermedio(String nombre) {
        super(nombre);
    }

    @Override
    protected boolean puedeResolver(Ticket t) {
        return false;
    }
}
