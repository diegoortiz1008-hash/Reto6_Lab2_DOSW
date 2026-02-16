package com.example.Reto6LabDOSW2;

public class TecnicoBasico extends Tecnico {

    public TecnicoBasico(String nombre) {
        super(nombre);
    }

    @Override
    protected boolean puedeResolver(Ticket t) {
        return "BASICO".equals(t.getDificultad()) && "BAJA".equals(t.getPrioridad());
    }
}
