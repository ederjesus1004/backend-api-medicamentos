package dev.eder.medicamento.service;

import java.util.List;

import dev.eder.medicamento.dto.MedicamentoRequest;
import dev.eder.medicamento.dto.MedicamentoResponse;

public interface MedicamentoService {

    List<MedicamentoResponse> listar();

    MedicamentoResponse obtenerPorId(Long id);

    MedicamentoResponse crear(MedicamentoRequest request);

    MedicamentoResponse actualizar(Long id, MedicamentoRequest request);

    void eliminar(Long id);
}
