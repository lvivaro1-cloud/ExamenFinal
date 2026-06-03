package controller;

import model.CitaModel;
import dao.citaDao;
import java.util.Date;
import java.util.List;

public class CitaController {

    private final CitaDao dao = new CitaDao();

  
    public boolean insertar(int id_paciente, Date fecha_cita, String descripcion, boolean estado_cita) {

        CitaModel cita = new CitaModel(id_paciente, fecha_cita, descripcion, estado_cita);

        return dao.insertar(cita);
    }

    
    public boolean actualizar(int id, int id_paciente, Date fecha_cita, String descripcion, boolean estado_cita) {
        CitaModel cita = new CitaModel(id, id_paciente, fecha_cita, descripcion, estado_cita);

        return dao.actualizar(cita);
    }

   
    public boolean eliminar(int id, boolean cambiar_estado) {
        return dao.cambiarEstado(id, cambiar_estado);
    }

    
    public List<CitaModel> listar() {
        return dao.listar();
    }

}