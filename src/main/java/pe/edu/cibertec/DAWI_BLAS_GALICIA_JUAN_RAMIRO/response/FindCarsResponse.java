package pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.response;

import pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.dto.CarDto;

import java.util.List;

public record FindCarsResponse(String code, String message, List<CarDto> cars) {
}
