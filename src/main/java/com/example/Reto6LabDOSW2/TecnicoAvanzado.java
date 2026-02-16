package com.example.Reto6LabDOSW2;

public class TecnicoAvanzado extends Tecnico {

    public TecnicoAvanzado(String nombre) {
        super(nombre);
    }

    @Override
    protected boolean puedeResolver(Ticket t) {
        return "INTERMEDIO".equals(t.getDificultad()) || "AVANZADO".equals(t.getDificultad());
    }
}
