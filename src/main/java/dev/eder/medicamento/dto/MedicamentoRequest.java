package dev.eder.medicamento.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record MedicamentoRequest(
        @NotBlank(message = "El codigo es obligatorio") @Pattern(regexp = "^MED-\\d{5}$", message = "El codigo tiene que seguir esta orden MED-12345") String codigo,

        @NotBlank(message = "El nombre es obligatorio") @Size(max = 100, message = "El nombre solo puede tener 100 caracteres maximo") String nombre,

        @NotBlank(message = "El laboratorio es obligatorio") @Size(max = 80, message = "El laboratorio puede tener maximo 80 caracteres") String laboratorio,

        @NotBlank(message = "La presentacion es obligatoria") @Size(max = 50, message = "La presentacion puede tener maximo solo 50 caracteres") String presentacion,

        @NotNull(message = "El stock es obligatorio") @Min(value = 0, message = "El stock minimo es de 0") @Max(value = 1000, message = "El stock maximo es de 1000") Integer stock,

        @NotNull(message = "El precio es obligatorio") @Positive(message = "El precio tien que ser mayor que 0") BigDecimal precio) {

}
