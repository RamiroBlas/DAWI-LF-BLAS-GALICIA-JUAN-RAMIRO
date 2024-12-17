create database fabric;

use fabric;

CREATE TABLE car (
    car_id INT AUTO_INCREMENT PRIMARY KEY,
    make VARCHAR(50),
    model VARCHAR(50),
    year INT,
    vin VARCHAR(50),
    license_plate VARCHAR(20),
    owner_name VARCHAR(100),
    owner_contact VARCHAR(50),
    purchase_date DATE,
    mileage INT,
    engine_type VARCHAR(50),
    color VARCHAR(30),
    insurance_company VARCHAR(100),
    insurance_policy_number VARCHAR(50),
    registration_expiration_date DATE,
    service_due_date DATE
);

INSERT INTO car (make, model, year, vin, license_plate, owner_name, owner_contact, purchase_date, mileage, engine_type, color, insurance_company, insurance_policy_number, registration_expiration_date, service_due_date) VALUES
('Toyota', 'Corolla', 2018, '1NXBR12E3YZ123456', 'ABC123', 'Juan Perez', '555-1234', '2018-01-15', 25000, 'Gasoline', 'Red', 'Seguros del Sol', 'INS123456', '2025-01-15', '2024-07-15'),
('Honda', 'Civic', 2020, '2HGES26785H654321', 'XYZ789', 'Maria Lopez', '555-5678', '2020-05-10', 15000, 'Gasoline', 'Blue', 'ProtectAuto', 'INS789012', '2026-05-10', '2025-11-10'),
('Ford', 'Focus', 2019, '1FAFP34N06W765432', 'DEF456', 'Carlos Jimenez', '555-8765', '2019-03-20', 30000, 'Diesel', 'Black', 'AutoSeguro', 'INS345678', '2024-03-20', '2023-09-20'),
('Chevrolet', 'Malibu', 2017, '1G1ZD5ST1HF123456', 'GHI123', 'Ana Martinez', '555-4321', '2017-08-05', 45000, 'Gasoline', 'White', 'AutoProtegido', 'INS901234', '2023-08-05', '2023-02-05'),
('Nissan', 'Altima', 2021, '1N4AL11D75C123456', 'JKL456', 'Luis Rodriguez', '555-3456', '2021-06-15', 10000, 'Gasoline', 'Silver', 'SegurosTotal', 'INS567890', '2027-06-15', '2026-12-15'),
('Mazda', '3', 2022, 'JM1BPACL1M1234567', 'MNO789', 'Sofia Gonzalez', '555-6789', '2022-09-20', 5000, 'Gasoline', 'Gray', 'ProtecCar', 'INS234567', '2028-09-20', '2028-03-20'),
('Hyundai', 'Elantra', 2016, 'KMHDH4AE6DU123456', 'PQR123', 'Pedro Alvarez', '555-9876', '2016-11-05', 60000, 'Gasoline', 'Green', 'AseguraTodo', 'INS876543', '2022-11-05', '2022-05-05'),
('Kia', 'Optima', 2015, '5XXGT4L34FG123456', 'STU456', 'Isabel Ramirez', '555-2345', '2015-02-10', 75000, 'Gasoline', 'Yellow', 'CarSeguros', 'INS345678', '2021-02-10', '2020-08-10'),
('Volkswagen', 'Jetta', 2014, '3VW2K7AJ6EM123456', 'VWX789', 'Manuel Diaz', '555-8765', '2014-05-15', 90000, 'Gasoline', 'Blue', 'SeguroMovil', 'INS901234', '2020-05-15', '2019-11-15'),
('Subaru', 'Impreza', 2013, 'JF1GJAA67DG123456', 'YZA123', 'Patricia Sanchez', '555-6543', '2013-12-01', 100000, 'Gasoline', 'Red', 'AsegurAuto', 'INS567890', '2019-12-01', '2019-06-01');
