package pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.response;

import pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.dto.CardDetailDto;

public record FindCarByIdResponse(String code, String message, CardDetailDto car) {
}
