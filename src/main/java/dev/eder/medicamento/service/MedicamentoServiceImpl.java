package dev.eder.medicamento.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.eder.medicamento.Mapper.MedicamentoMapper;
import dev.eder.medicamento.dto.MedicamentoRequest;
import dev.eder.medicamento.dto.MedicamentoResponse;
import dev.eder.medicamento.entity.Medicamento;
import dev.eder.medicamento.exception.RecursoDuplicadoException;
import dev.eder.medicamento.exception.RecursoNoEncontradoException;
import dev.eder.medicamento.repository.MedicamentoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicamentoServiceImpl implements MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MedicamentoResponse> listar() {
        return medicamentoRepository.findAll()
                .stream()
                .map(MedicamentoMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public MedicamentoResponse obtenerPorId(Long id) {
        return MedicamentoMapper.toResponse(buscarMedicamento(id));
    }

    @Override
    @Transactional
    public MedicamentoResponse crear(MedicamentoRequest request) {

        if (medicamentoRepository.existsByCodigo(request.codigo())) {
            throw new RecursoDuplicadoException("Ya existe un medicamento con ese codigo " + request.codigo());
        }
        Medicamento medicamento = MedicamentoMapper.toEntity(request);
        return MedicamentoMapper.toResponse(medicamentoRepository.save(medicamento));
    }

    @Override
    @Transactional
    public MedicamentoResponse actualizar(Long id, MedicamentoRequest request) {
        Medicamento medicamento = buscarMedicamento(id);
        if (medicamentoRepository.existsByCodigoAndIdNot(request.codigo(), id)) {
            throw new RecursoNoEncontradoException("Ya existe un medicamento con este codigo " + request.codigo());
        }
        MedicamentoMapper.actualizarEntidad(request, medicamento);
        return MedicamentoMapper.toResponse(medicamentoRepository.save(medicamento));
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Medicamento medicamento = buscarMedicamento(id);
        medicamentoRepository.delete(medicamento);
    }

    private Medicamento buscarMedicamento(Long id) {
        return medicamentoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("No existe el medicamento con id " + id));
    }

}
