package dev.eder.medicamento.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.eder.medicamento.dto.MedicamentoRequest;
import dev.eder.medicamento.dto.MedicamentoResponse;
import dev.eder.medicamento.service.MedicamentoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/medicamentos")
@RequiredArgsConstructor
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    @GetMapping
    public List<MedicamentoResponse> listar() {
        return medicamentoService.listar();
    }

    @GetMapping("/{id}")
    public MedicamentoResponse obtenerPorId(@PathVariable Long id) {
        return medicamentoService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedicamentoResponse crear(@Valid @RequestBody MedicamentoRequest request) {
        return medicamentoService.crear(request);
    }

    @PutMapping("/{id}")
    public MedicamentoResponse actualizar(@PathVariable Long id, @Valid @RequestBody MedicamentoRequest request) {
        return medicamentoService.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        medicamentoService.eliminar(id);
    }
}
