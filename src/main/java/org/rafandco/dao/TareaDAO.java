package org.rafandco.dao;

import org.rafandco.db.SingletonConnection;
import org.rafandco.model.Tarea;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TareaDAO {

    public void insertar(Tarea tarea) {
        // INSERT INTO tareas (...)
        Connection conexion = SingletonConnection.getConnection();
        String sql = """
                INSERT INTO tareas (titulo, descripcion, fechaCreacion) VALUES (?, ?, ?)
                """;

        try (PreparedStatement ps = SingletonConnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, tarea.getTitulo());
            ps.setString(2, tarea.getDescripcion());
            ps.setDate(3, Date.valueOf(tarea.getFechaCreacion()));
            ps.executeUpdate();
            System.out.println("Registro insertado exitosamente");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void actualizar(Tarea tarea) {
        // UPDATE tareas SET ... WHERE id = ?
        Connection conexion = SingletonConnection.getConnection();
        String sql = """
                UPDATE tareas
                SET(titulo = ?, descripcion = ?, completada = ?, fechaCreacion = ?)
                WHERE (id = ?)
                """;

        try (PreparedStatement ps = SingletonConnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, tarea.getTitulo());
            ps.setString(2, tarea.getDescripcion());
            ps.setBoolean(3, tarea.isCompletada());
            ps.setDate(4, Date.valueOf(tarea.getFechaCreacion()));
            ps.setInt(5, tarea.getId());
            ps.executeUpdate();
            System.out.println("Actualización realizada exitosamente");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void eliminar(int id) {
        // DELETE FROM tareas WHERE id = ?
        Connection conexion = SingletonConnection.getConnection();
        String sql = """
                DELETE FROM tareas WHERE (id = ?)
                """;

        try (PreparedStatement ps = SingletonConnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Registro eliminado exitosamente");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public Tarea buscarPorId(int id) {
        // SELECT ... FROM tareas WHERE id = ?
        Tarea tarea = null;
        Connection conexion = SingletonConnection.getConnection();
        String sql = """
                SELECT *
                FROM tareas WHERE (id = ?)
                """;

        try (PreparedStatement ps = SingletonConnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            int ident = rs.getInt("id");
            String titulo = rs.getString("titulo");
            String descripcion = rs.getString("descripcion");
            boolean completada = rs.getBoolean("completada");
            Date fechaCreacion = rs.getDate("fechaCreacion");

            tarea = new Tarea(ident, titulo, descripcion, completada, fechaCreacion.toLocalDate());

            rs.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return tarea;
    }

    public List<Tarea> listarTodas() {
        // SELECT ... FROM tareas
        Tarea tarea = null;
        List<Tarea> tareas = new ArrayList<>();
        Connection conexion = SingletonConnection.getConnection();
        String sql = """
                SELECT * FROM tareas
                """;

        try (PreparedStatement ps = SingletonConnection.getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            int ident = rs.getInt("id");
            String titulo = rs.getString("titulo");
            String descripcion = rs.getString("descripcion");
            boolean completada = rs.getBoolean("completada");
            Date fechaCreacion = rs.getDate("fechaCreacion");

            tarea = new Tarea(ident, titulo, descripcion, completada, fechaCreacion.toLocalDate());
            tareas.add(tarea);

            rs.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return tareas;
    }

}
