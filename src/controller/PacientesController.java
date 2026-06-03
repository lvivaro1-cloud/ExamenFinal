package controller;

import dao.PacientesDao;
import model.PacientesModel;
import java.util.Date;
import java.util.List;


public class PacientesController {

    private final PacientesDao dao = new PacientesDao();

    //insertar
    public boolean agregar(String nombre, String apellido, String telefono, String direccion, Date fecha_nacimiento) {
        PacientesModel paciente = new PacientesModel(nombre, apellido, telefono, direccion, fecha_nacimiento);

        return dao.Insertar(paciente);
    }
    
    //actualizar
    public boolean actualizar(int id, String nombre,String apellido, String telefono, String direccion, Date fecha_nacimiento){
        PacientesModel paciente = new PacientesModel(id, nombre, apellido, telefono, direccion, fecha_nacimiento);
        return dao.Actualizar(paciente);
    }
    
    //listar
    
    public List<PacientesModel> listar(){
        return dao.listar();
    }
    
}