package com.laurapaucara.forohub.controller;

import com.laurapaucara.forohub.controller.dto.TopicoCreateDTO;
import com.laurapaucara.forohub.controller.dto.TopicoResponseDTO;
import com.laurapaucara.forohub.controller.dto.TopicoUpdateDTO;
import com.laurapaucara.forohub.model.Topico;
import com.laurapaucara.forohub.repository.TopicoRepository;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoRepository repository;

    @Autowired
    public TopicoController(TopicoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<TopicoResponseDTO> crear(@Valid @RequestBody TopicoCreateDTO dto) {
        Topico t = new Topico();
        t.setTitulo(dto.getTitulo());
        t.setMensaje(dto.getMensaje());
        t.setAutor(dto.getAutor());
        if (t.getFechaCreacion() == null) {
            t.setFechaCreacion(LocalDateTime.now());
        }

        repository.save(t);

        URI uri = URI.create("/topicos/" + t.getId());
        return ResponseEntity.created(uri).body(toDto(t));
    }

    @GetMapping
    public List<TopicoResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoResponseDTO> obtener(@PathVariable Long id) {
        return repository.findById(id)
                .map(t -> ResponseEntity.ok(toDto(t)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoResponseDTO> actualizar(@PathVariable Long id,
                                                        @Valid @RequestBody TopicoUpdateDTO dto) {
        return repository.findById(id)
                .map(t -> {
                    t.setTitulo(dto.getTitulo());
                    t.setMensaje(dto.getMensaje());
                    repository.save(t);
                    return ResponseEntity.ok(toDto(t));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private TopicoResponseDTO toDto(Topico t) {
        return new TopicoResponseDTO(
                t.getId(),
                t.getTitulo(),
                t.getMensaje(),
                t.getAutor(),
                t.getFechaCreacion()
        );
    }
}
