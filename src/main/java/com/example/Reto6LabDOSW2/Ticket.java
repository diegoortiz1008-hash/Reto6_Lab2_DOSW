package com.example.Reto6LabDOSW2;

public class Ticket {

    private int id;
    private String dificultad; 
    private String prioridad;   
    private String descripcion;

    private boolean resuelto;
    private String resueltoPor;

    public Ticket(int id, String dificultad, String prioridad, String descripcion) {
        this.id = id;
        this.dificultad = dificultad.toUpperCase();
        this.prioridad = prioridad.toUpperCase();
        this.descripcion = descripcion;
        this.resuelto = false;
        this.resueltoPor = "";
    }

    public int getId() {
        return id;
    }

    public String getDificultad() {
        return dificultad;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isResuelto() {
        return resuelto;
    }

    public String getResueltoPor() {
        return resueltoPor;
    }

    public void marcarResuelto(String tecnico) {
        this.resuelto = true;
        this.resueltoPor = tecnico.toUpperCase();
    }

    public int valorPrioridad() {
        switch (prioridad) {
            case "BAJA": return 1;
            case "MEDIA": return 2;
            case "ALTA": return 3;
            default: return 0;
        }
    }
}
