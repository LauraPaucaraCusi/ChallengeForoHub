package com.laurapaucara.forohub.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class TopicoUpdateDTO {
    @NotBlank
    private String titulo;
    @NotBlank
    private String mensaje;

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
}
