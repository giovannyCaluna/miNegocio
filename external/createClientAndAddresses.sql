-- V1__Create_Client_and_Address_Tables.sql
select * from clients c ;
select * from addresses a ;
delete  table clients;
delete table addresses;
CREATE TABLE clients (
    id SERIAL PRIMARY KEY,
    identification_type VARCHAR(255),
    identification_number VARCHAR(255),
    name VARCHAR(255),
    email VARCHAR(255),
    cellphone VARCHAR(255),
    matriz_address_id BIGINT
);

CREATE TABLE addresses (
    id SERIAL PRIMARY KEY,
    calle VARCHAR(255),
    ciudad VARCHAR(255),
    pais VARCHAR(255),
    client_id BIGINT REFERENCES clients(id)
);



-- Insert 20 sample clients
INSERT INTO clients (identification_type, identification_number, name, email, cellphone, matriz_address_id)
VALUES
    ('DNI', '12121212', 'Daniel Sandoval', 'dani@test.com', '000000', 1212),
    ('DNI', '34343434', 'Maria Rodriguez', 'maria@test.com', '111111', 3434),
    ('Passport', '56565656', 'Juan Perez', 'juan@test.com', '222222', 5656),
    ('DNI', '78787878', 'Ana Garcia', 'ana@test.com', '333333', 7878),
    ('Passport', '90909090', 'Luis Martinez', 'luis@test.com', '444444', 9090),
    ('DNI', '10101010', 'Laura Sanchez', 'laura@test.com', '555555', 1010),
    ('DNI', '12121222', 'Pedro Lopez', 'pedro@test.com', '666666', 1212),
    ('Passport', '34343444', 'Isabel Torres', 'isabel@test.com', '777777', 3434),
    ('DNI', '56565666', 'Carlos Gomez', 'carlos@test.com', '888888', 5656),
    ('DNI', '78787888', 'Rosa Fernandez', 'rosa@test.com', '999999', 7878),
    ('Passport', '90909099', 'Jose Ramirez', 'jose@test.com', '101010', 9090),
    ('DNI', '10101011', 'Sofia Herrera', 'sofia@test.com', '111111', 1010),
    ('DNI', '12121233', 'Gabriel Rodriguez', 'gabriel@test.com', '121212', 1212),
    ('Passport', '34343455', 'Elena Perez', 'elena@test.com', '131313', 3434),
    ('DNI', '56565677', 'Hector Torres', 'hector@test.com', '141414', 5656),
    ('DNI', '78787899', 'Monica Sanchez', 'monica@test.com', '151515', 7878),
    ('Passport', '90909100', 'Andres Garcia', 'andres@test.com', '161616', 9090),
    ('DNI', '10101012', 'Natalia Lopez', 'natalia@test.com', '171717', 1010),
    ('DNI', '12121244', 'Fernando Gomez', 'fernando@test.com', '181818', 1212),
    ('Passport', '34343466', 'Carmen Fernandez', 'carmen@test.com', '191919', 3434);

-- Insert 20 sample addresses
INSERT INTO addresses (calle, ciudad, pais, client_id)
VALUES
    ('Sample Street 1', 'Sample City 1', 'Sample Country 1', 21),
    ('Sample Street 2', 'Sample City 2', 'Sample Country 2', 22),
    ('Sample Street 3', 'Sample City 3', 'Sample Country 3', 23),
    ('Sample Street 4', 'Sample City 4', 'Sample Country 4', 24),
    ('Sample Street 5', 'Sample City 5', 'Sample Country 5', 25),
    ('Sample Street 6', 'Sample City 6', 'Sample Country 6', 26),
    ('Sample Street 7', 'Sample City 7', 'Sample Country 7', 27),
    ('Sample Street 8', 'Sample City 8', 'Sample Country 8', 28),
    ('Sample Street 9', 'Sample City 9', 'Sample Country 9', 29),
    ('Sample Street 10', 'Sample City 10', 'Sample Country 10', 21),
    ('Sample Street 11', 'Sample City 11', 'Sample Country 11', 22),
    ('Sample Street 12', 'Sample City 12', 'Sample Country 12', 23),
    ('Sample Street 13', 'Sample City 13', 'Sample Country 13', 23),
    ('Sample Street 14', 'Sample City 14', 'Sample Country 14', 24),
    ('Sample Street 15', 'Sample City 15', 'Sample Country 15', 25),
    ('Sample Street 16', 'Sample City 16', 'Sample Country 16', 26),
    ('Sample Street 17', 'Sample City 17', 'Sample Country 17', 27),
    ('Sample Street 18', 'Sample City 18', 'Sample Country 18', 22),
    ('Sample Street 19', 'Sample City 19', 'Sample Country 19', 21),
    ('Sample Street 20', 'Sample City 20', 'Sample Country 20', 25);
