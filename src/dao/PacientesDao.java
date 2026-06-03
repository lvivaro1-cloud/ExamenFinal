import connection.CreateConnection;
import model.PacientesModel
 

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
 

public class PacientesDao {
    private final CreateConnection connFactory = new CreateConnection();
 

    public List<Paciente> obtenerTodos() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT into pacientes(id_paciente, fecha_cita, descripcion, estadoCita, precio, tipo_cita)";
 

        try (Connection conn = connFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(ColocaMiQuery);
             ResultSet rs = ps.executeQuery() ) {
 

            while (rs siguiente) {
                Empleado emp = .......
                lista.add(emp);
            }
            Close Prepared;
            Close Connection ;
        }  catch (Exception e) {
            e.printStackTrace();
        }
 

        return lista;
    }
 

    public boolean guardar(Paciente pt) {
        String sql = "INSERT INTO tabla (campos) VALUES (?,?,?,?,?,?)";
 

        try (
            Connection conn = connFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, emp.ObtenerNombre());
         
 

            ps.executeQuery();
           
           close connection PS;
            Cerrar la conexion general
           
            return true;
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
 

        return false;
    }
 

     
}