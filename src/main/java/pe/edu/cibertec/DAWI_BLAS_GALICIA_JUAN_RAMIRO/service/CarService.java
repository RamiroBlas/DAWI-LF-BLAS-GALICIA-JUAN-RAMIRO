package pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.service;

import pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.dto.CarDto;
import pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.dto.CardCreateDto;
import pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.dto.CardDetailDto;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<CarDto> findAll() throws Exception;
    Optional<CarDto> findAllOrById(int id) throws Exception;
    Optional<CardDetailDto> findById(Integer id) throws Exception;
    boolean createCar(CardCreateDto cardCreateDto) throws Exception;
    boolean deleteCar(int id) throws Exception;
    boolean updateCar(CardDetailDto cardDetailDto) throws Exception;
}
