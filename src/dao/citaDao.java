package dao;

import model.CitaModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import connection.CreateConnection;

public class CitaDao {

    private final CreateConnection connf = new CreateConnection();

    
    public boolean insertar(CitaModel cita) {

       
        String query = "INSERT INTO citas(id_paciente, fecha_cita,descripcion, estadoCita) values (?,?,?,?)";

        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, cita.getId_paciente());
            ps.setTimestamp(2, new Timestamp(cita.getFecha_cita().getTime()));
            ps.setString(3, cita.getDescripcion());
            ps.setBoolean(4, cita.isEstado_cita());

            ps.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public boolean actualizar(CitaModel cita) {

        
        String query = "UPDATE citas SET id_paciente = ? , fecha_cita = ?, descripcion = ?, estadoCita = ? where id = ?";
       
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, cita.getId_paciente());
            ps.setTimestamp(2, new Timestamp(cita.getFecha_cita().getTime()));
            ps.setString(3, cita.getDescripcion());
            ps.setBoolean(4, cita.isEstado_cita());
            ps.setInt(5, cita.getId());

            ps.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }
    }

    
    public boolean cambiarEstado(int id, boolean estado) {

       
        String query = "Update citas set estadoCita = ? where id = ?";

       
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setBoolean(1, estado);
            ps.setInt(2, id);

            ps.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

   
    public List<CitaModel> listar() {
        List<CitaModel> listar = new ArrayList<>();

        
        String query = "SELECT *FROM citas group by id";

        
        try (Connection conn = connf.getConnection(); PreparedStatement ps = conn.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CitaModel cita = new CitaModel(
                        rs.getInt("id"),
                        rs.getInt("id_paciente"),
                        rs.getTimestamp("fecha_cita"),
                        rs.getString("descripcion"),
                        rs.getBoolean("estadoCita"));

                listar.add(cita);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }

        return listar;
    }
    
    

}