package model;


import java.util.Date;

public class CitaModel {

    private int id;
    private int id_paciente;
    private Date fecha_cita;
    private String descripcion;
    private boolean estado_cita;

    public CitaModel(int id_paciente, Date fecha_cita, String descripcion, boolean estado_cita) {
        this.id_paciente = id_paciente;
        this.fecha_cita = fecha_cita;
        this.descripcion = descripcion;
        this.estado_cita = estado_cita;
    }

    public CitaModel(int id, int id_paciente, Date fecha_cita, String descripcion, boolean estado_cita) {
        this.id = id;
        this.id_paciente = id_paciente;
        this.fecha_cita = fecha_cita;
        this.descripcion = descripcion;
        this.estado_cita = estado_cita;
    }

    
    
    
    public CitaModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Date getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(Date fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado_cita() {
        return estado_cita;
    }

    public void setEstado_cita(boolean estado_cita) {
        this.estado_cita = estado_cita;
    }



}

