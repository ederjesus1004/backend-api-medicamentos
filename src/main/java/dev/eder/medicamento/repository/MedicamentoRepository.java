package dev.eder.medicamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.eder.medicamento.entity.Medicamento;

public interface MedicamentoRepository extends  JpaRepository<Medicamento, Long>{

    boolean existsByCodigo (String codigo);

    boolean existsByCodigoAndIdNot(String codigo, Long id);

}
