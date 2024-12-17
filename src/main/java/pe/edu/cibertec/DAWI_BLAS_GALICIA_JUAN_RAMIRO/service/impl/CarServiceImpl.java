package pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.service.impl;

import pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.dto.CarDto;
import pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.dto.CardCreateDto;
import pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.dto.CardDetailDto;
import pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.entity.Car;
import pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.repository.CarRepository;
import pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.service.CarService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<CarDto> findAll() throws Exception {
        List<CarDto> cars = new ArrayList<>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            CarDto carDto = new CarDto(
                    car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getYear(),
                    car.getLicensePlate(),
                    car.getOwnerName()
            );
            cars.add(carDto);
        });
        return cars;
    }

    @Override
    public Optional<CarDto> findAllOrById(int id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CarDto(
                car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getLicensePlate(),
                car.getOwnerName()
        ));
    }

    @Override
    public Optional<CardDetailDto> findById(Integer id) throws Exception {
        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CardDetailDto(
                car.getCarId(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicensePlate(),
                car.getOwnerName(),
                car.getOwnerContact(),
                car.getPurchaseDate(),
                car.getMileage(),
                car.getEngineType(),
                car.getColor(),
                car.getInsuranceCompany(),
                car.getInsurancePolicyNumber(),
                car.getRegistrationExpirationDate(),
                car.getServiceDueDate()
        ));
    }

    @Override
    public boolean updateCar(CardDetailDto cardDetailDto) throws Exception {
        Optional<Car> optional = carRepository.findById(cardDetailDto.carId());
        if (optional.isPresent()) {
            Car car = optional.get();
            car.setMake(cardDetailDto.make());
            car.setModel(cardDetailDto.model());
            car.setYear(cardDetailDto.year());
            car.setVin(cardDetailDto.vin());
            car.setLicensePlate(cardDetailDto.licensePlate());
            car.setOwnerName(cardDetailDto.ownerName());
            car.setOwnerContact(cardDetailDto.ownerContact());
            car.setPurchaseDate(cardDetailDto.purchaseDate());
            car.setMileage(cardDetailDto.mileage());
            car.setEngineType(cardDetailDto.engineType());
            car.setColor(cardDetailDto.color());
            car.setInsuranceCompany(cardDetailDto.insuranceCompany());
            car.setInsurancePolicyNumber(cardDetailDto.insurancePolicyNumber());
            car.setRegistrationExpirationDate(cardDetailDto.registrationExpirationDate());
            car.setServiceDueDate(cardDetailDto.serviceDueDate());
            carRepository.save(car);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCar(int id) throws Exception {
        if (carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean createCar(CardCreateDto cardCreateDto) throws Exception {
        Car car = new Car();
        car.setMake(cardCreateDto.make());
        car.setModel(cardCreateDto.model());
        car.setYear(cardCreateDto.year());
        car.setVin(cardCreateDto.vin());
        car.setLicensePlate(cardCreateDto.licensePlate());
        car.setOwnerName(cardCreateDto.ownerName());
        car.setOwnerContact(cardCreateDto.ownerContact());
        car.setPurchaseDate(cardCreateDto.purchaseDate());
        car.setMileage(cardCreateDto.mileage());
        car.setEngineType(cardCreateDto.engineType());
        car.setColor(cardCreateDto.color());
        car.setInsuranceCompany(cardCreateDto.insuranceCompany());
        car.setInsurancePolicyNumber(cardCreateDto.insurancePolicyNumber());
        car.setRegistrationExpirationDate(cardCreateDto.registrationExpirationDate());
        car.setServiceDueDate(cardCreateDto.serviceDueDate());
        carRepository.save(car);
        return true;
    }

}
