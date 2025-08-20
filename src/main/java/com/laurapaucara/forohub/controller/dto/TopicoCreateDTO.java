package com.laurapaucara.forohub.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class TopicoCreateDTO {
    @NotBlank
    private String titulo;
    @NotBlank
    private String mensaje;
    @NotBlank
    private String autor;

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
}
