package pe.edu.cibertec.DAWI_BLAS_GALICIA_JUAN_RAMIRO.dto;

import java.time.LocalDate;

public record CardCreateDto(String make,
                            String model,
                            Integer year,
                            String vin,
                            String licensePlate,
                            String ownerName,
                            String ownerContact,
                            LocalDate purchaseDate,
                            Integer mileage,
                            String engineType,
                            String color,
                            String insuranceCompany,
                            String insurancePolicyNumber,
                            LocalDate registrationExpirationDate,
                            LocalDate serviceDueDate) {
}
