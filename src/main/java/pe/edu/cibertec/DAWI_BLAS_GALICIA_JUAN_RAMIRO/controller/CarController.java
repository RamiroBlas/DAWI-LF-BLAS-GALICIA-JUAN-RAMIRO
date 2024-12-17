package pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.controller;

import pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.dto.CarDto;
import pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.dto.CardCreateDto;
import pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.dto.CardDetailDto;
import pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.response.*;
import pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/lista")
    public FindCarsResponse findCars(@RequestParam(value = "id", defaultValue = "0") String id) {
        try {
            if (Integer.parseInt(id) > 0) {
                Optional<CarDto> optional = carService.findAllOrById(Integer.parseInt(id));
                if (optional.isPresent()) {
                    CarDto carDto = optional.get();
                    return new FindCarsResponse("01", "", List.of(carDto));
                } else {
                    return new FindCarsResponse("02", "Id no encontrado", null);
                }
            } else {
                List<CarDto> cars = carService.findAll();
                if (!cars.isEmpty()) {
                    return new FindCarsResponse("01", "", cars);
                } else {
                    return new FindCarsResponse("03", "lista no encontrada", cars);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsResponse("99", "Parametro incorrecto", null);
        }
    }

    @GetMapping("/detalle")
    public FindCarByIdResponse findCarById(@RequestParam(value = "id", defaultValue = "0") String id) {
        try {
            if (Integer.parseInt(id) > 0) {
                Optional<CardDetailDto> optional = carService.findById(Integer.parseInt(id));
                if (optional.isPresent()) {
                    CardDetailDto carDetailDto = optional.get();
                    return new FindCarByIdResponse("01", "", carDetailDto);
                } else {
                    return new FindCarByIdResponse("02", "Id no encontrado", null);
                }
            } else {
                return new FindCarByIdResponse("03", "Colocar numero mayor a cero", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarByIdResponse("99", "Parametro incorrecto", null);
        }
    }

    @PostMapping("/crear")
    public CreateCarResponse createCar(@RequestBody CardCreateDto cardCreateDto) {
        try {
            boolean created = carService.createCar(cardCreateDto);
            if (created) {
                return new CreateCarResponse("01", "Se creo exitosamente");
            } else {
                return new CreateCarResponse("02", "Error al crear");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99", "Parametro incorrecto");
        }
    }

    @PutMapping("/actualizar")
    public UpdateCarResponse updateCar(@RequestBody CardDetailDto cardDetailDto) {
        try {
            boolean updated = carService.updateCar(cardDetailDto);
            if (updated) {
                return new UpdateCarResponse("01", "Actualizado exitosamente");
            } else {
                return new UpdateCarResponse("02", "Fallo al actualizar");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99", "Parametro incorrecto");
        }
    }

    @DeleteMapping("/remover")
    public DeleteCarResponse deleteCar(@RequestParam(value = "id") int id) {
        try {
            boolean deleted = carService.deleteCar(id);
            if (deleted) {
                return new DeleteCarResponse("01", "Eliminado satisfactoriamente");
            } else {
                return new DeleteCarResponse("02", "Fallo al eliminar");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99", "Parametro incorrecto");
        }
    }

}
