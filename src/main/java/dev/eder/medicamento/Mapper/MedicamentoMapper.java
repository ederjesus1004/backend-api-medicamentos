package dev.eder.medicamento.Mapper;

import dev.eder.medicamento.dto.MedicamentoRequest;
import dev.eder.medicamento.dto.MedicamentoResponse;
import dev.eder.medicamento.entity.Medicamento;

public class MedicamentoMapper {

    private MedicamentoMapper(){
    }

    public static Medicamento toEntity (MedicamentoRequest request){
        Medicamento medicamento = new Medicamento();
        actualizarEntidad(request,medicamento);
        return medicamento;
    }

    public static void actualizarEntidad(MedicamentoRequest request, Medicamento medicamento){
        medicamento.setCodigo(request.codigo().trim());
        medicamento.setNombre(request.nombre().trim());
        medicamento.setLaboratorio(request.laboratorio());
        medicamento.setPresentacion(request.presentacion());
        medicamento.setStock(request.stock());
        medicamento.setPrecio(request.precio());
    }

    public static MedicamentoResponse toResponse(Medicamento medicamento){
        return MedicamentoResponse.builder()
        .id(medicamento.getId())
        .codigo(medicamento.getCodigo())
        .descripcion("(" + medicamento.getNombre() + " - "+ medicamento.getPresentacion() + " - " + medicamento.getLaboratorio() + ")")
        .stock(medicamento.getStock())
        .precio(medicamento.getPrecio())
        .fechaRegistro(medicamento.getFechaRegistro())
        .build();
    }

    


}
