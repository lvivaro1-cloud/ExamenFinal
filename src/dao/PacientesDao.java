package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connection.CreateConnection;
import model.PacientesModel;

public class PacientesDao {

    private final CreateConnection connf = new CreateConnection();

  
    public boolean Insertar(PacientesModel paciente) {
        
        String query = "INSERT INTO pacientes(nombre,apellido,telefono,direccion,fecha_nacimiento) values (?,?,?,?,?)";
       
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setString(3, paciente.getTelefono());
            ps.setString(4, paciente.getDireccion());
            ps.setTimestamp(5, new Timestamp(paciente.getFecha_nacimiento().getTime()));
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public boolean Actualizar(PacientesModel paciente) {
        
        String query = "UPDATE pacientes set nombre = ?,apellido = ?,telefono = ?,direccion = ?,fecha_nacimiento = ? where id = ?";
        
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, paciente.getNombre());
            ps.setString(2, paciente.getApellido());
            ps.setString(3, paciente.getTelefono());
            ps.setString(4, paciente.getDireccion());
            ps.setTimestamp(5, new Timestamp(paciente.getFecha_nacimiento().getTime()));
            ps.setInt(6, paciente.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public List<PacientesModel> listar() {
        List<PacientesModel> listar = new ArrayList<>();
        
        String query = "SELECT * FROM pacientes order by id";
       
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                PacientesModel paciente = new PacientesModel(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("direccion"),
                        rs.getTimestamp("fecha_nacimiento")
                );
                listar.add(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listar;
    }
}