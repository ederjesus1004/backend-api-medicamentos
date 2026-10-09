package dev.eder.medicamento.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record MedicamentoResponse(
    Long id,
    String codigo,
    String descripcion,
    Integer stock,
    BigDecimal precio,
    LocalDateTime fechaRegistro
) {

}
