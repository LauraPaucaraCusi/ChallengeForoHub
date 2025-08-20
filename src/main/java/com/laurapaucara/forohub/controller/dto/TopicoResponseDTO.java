package com.laurapaucara.forohub.controller.dto;

import java.time.LocalDateTime;

public class TopicoResponseDTO {
    private Long id;
    private String titulo;
    private String mensaje;
    private String autor;
    private LocalDateTime fechaCreacion;

    public TopicoResponseDTO(Long id, String titulo, String mensaje, String autor, LocalDateTime fechaCreacion) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor = autor;
        this.fechaCreacion = fechaCreacion;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getMensaje() { return mensaje; }
    public String getAutor() { return autor; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
}
