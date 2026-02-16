package com.example.Reto6LabDOSW2;

public abstract class Tecnico {

    protected final String nombre; 
    private Tecnico siguiente;

    protected Tecnico(String nombre) {
        this.nombre = normalizar(nombre);
    }

    public Tecnico setSiguiente(Tecnico siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }
    public final void procesar(Ticket ticket) {
        if (ticket == null) return;

        if (puedeResolver(ticket)) {
            ticket.marcarResuelto(nombre);
            return;
        }

        if (siguiente != null) {
            siguiente.procesar(ticket);
        }
    }

    protected abstract boolean puedeResolver(Ticket t);

    protected String normalizar(String s) {
        return (s == null) ? "" : s.trim().toUpperCase();
    }
}
