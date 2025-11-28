package org.rafandco.model;

import java.time.LocalDate;

public class Tarea {
    /// /// /// /// /// /// /// /// /// ///
    /// ATRIBUTOS
    /// /// /// /// /// /// /// /// /// ///
    private int id;
    private String titulo;
    private String descripcion;
    private boolean completada;
    private LocalDate fechaCreacion;

    /// /// /// /// /// /// /// /// /// ///
    /// CONSTRUCTOR PARA TAREAS NUEVAS
    /// /// /// /// /// /// /// /// /// ///
    public Tarea(String titulo, String descripcion, LocalDate fechaCreacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
    }

    /// /// /// /// /// /// /// ///
    /// CONSTRUCTOR COMPLETO
    /// /// /// /// /// /// /// ///
    public Tarea(int id, String titulo, String descripcion, boolean completada, LocalDate fechaCreacion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.completada = completada;
        this.fechaCreacion = fechaCreacion;
    }

    /// /// /// /// /// /// /// /// /// ///
    /// GETTERS
    /// /// /// /// /// /// /// /// /// ///
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    /// /// /// /// /// /// /// /// /// ///
    /// SETTERS
    /// /// /// /// /// /// /// /// /// ///
    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        if (titulo.isEmpty()) {
            System.err.println("El título no puede estar vacío.");
        } else {
            this.titulo = titulo;
        }
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /// /// /// /// /// /// /// /// /// ///
    /// TOSTRING
    /// /// /// /// /// /// /// /// /// ///
    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", completada=" + completada +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
