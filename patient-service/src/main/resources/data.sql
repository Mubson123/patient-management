CREATE TABLE IF NOT EXISTS patient
(
    id         UUID PRIMARY KEY,
    gender     VARCHAR(10)  NOT NULL,   -- MALE | FEMALE | OTHER | UNKNOWN
    firstname  VARCHAR(100) NOT NULL,
    lastname   VARCHAR(100) NOT NULL,
    birth_date DATE         NOT NULL,
    phone      VARCHAR(30),
    email      VARCHAR(255) UNIQUE,
    street     VARCHAR(255) NOT NULL,
    zip_code   VARCHAR(20)  NOT NULL,
    city       VARCHAR(100) NOT NULL
);

-- Springfield (Nürnberg area)
INSERT INTO patient (id, gender, firstname, lastname, birth_date, phone, email, street, zip_code, city)
SELECT '123e4567-e89b-12d3-a456-426614174000','MALE','John','Doe','1985-06-15',
       '+49 911 1234567','john.doe@example.com','123 Main St','90402','Springfield'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id='123e4567-e89b-12d3-a456-426614174000');

INSERT INTO patient (id, gender, firstname, lastname, birth_date, phone, email, street, zip_code, city)
SELECT '123e4567-e89b-12d3-a456-426614174003','MALE','Bob','Brown','1982-11-30',
       '+49 911 2345678','bob.brown@example.com','321 Pine St','90403','Springfield'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id='123e4567-e89b-12d3-a456-426614174003');

INSERT INTO patient (id, gender, firstname, lastname, birth_date, phone, email, street, zip_code, city)
SELECT '223e4567-e89b-12d3-a456-426614174005','MALE','Michael','Green','1988-07-25',
       '+49 911 3456789','michael.green@example.com','987 Cedar St','90404','Springfield'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id='223e4567-e89b-12d3-a456-426614174005');

INSERT INTO patient (id, gender, firstname, lastname, birth_date, phone, email, street, zip_code, city)
SELECT '223e4567-e89b-12d3-a456-426614174008','FEMALE','Laura','White','1989-09-02',
       '+49 911 4567890','laura.white@example.com','789 Palm St','90405','Springfield'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id='223e4567-e89b-12d3-a456-426614174008');

INSERT INTO patient (id, gender, firstname, lastname, birth_date, phone, email, street, zip_code, city)
SELECT '223e4567-e89b-12d3-a456-426614174011','MALE','Ethan','Martinez','1984-05-03',
       '+49 911 5678901','ethan.martinez@example.com','987 Redwood St','90406','Springfield'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id='223e4567-e89b-12d3-a456-426614174011');

INSERT INTO patient (id, gender, firstname, lastname, birth_date, phone, email, street, zip_code, city)
SELECT '223e4567-e89b-12d3-a456-426614174014','FEMALE','Isabella','Walker','1987-10-17',
       '+49 911 6789012','isabella.walker@example.com','789 Willow St','90407','Springfield'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id='223e4567-e89b-12d3-a456-426614174014');

-- Shelbyville (Fürth area)
INSERT INTO patient (id, gender, firstname, lastname, birth_date, phone, email, street, zip_code, city)
SELECT '123e4567-e89b-12d3-a456-426614174001','FEMALE','Jane','Smith','1990-09-23',
       '+49 911 7890123','jane.smith@example.com','456 Elm St','90762','Shelbyville'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id='123e4567-e89b-12d3-a456-426614174001');

INSERT INTO patient (id, gender, firstname, lastname, birth_date, phone, email, street, zip_code, city)
SELECT '123e4567-e89b-12d3-a456-426614174004','FEMALE','Emily','Davis','1995-02-05',
       '+49 911 8901234','emily.davis@example.com','654 Maple St','90763','Shelbyville'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id='123e4567-e89b-12d3-a456-426614174004');

INSERT INTO patient (id, gender, firstname, lastname, birth_date, phone, email, street, zip_code, city)
SELECT '223e4567-e89b-12d3-a456-426614174006','FEMALE','Sarah','Taylor','1992-04-18',
       '+49 911 9012345','sarah.taylor@example.com','123 Birch St','90764','Shelbyville'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id='223e4567-e89b-12d3-a456-426614174006');

INSERT INTO patient (id, gender, firstname, lastname, birth_date, phone, email, street, zip_code, city)
SELECT '223e4567-e89b-12d3-a456-426614174009','MALE','James','Harris','1993-11-15',
       '+49 911 0123456','james.harris@example.com','321 Cherry St','90765','Shelbyville'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id='223e4567-e89b-12d3-a456-426614174009');

INSERT INTO patient (id, gender, firstname, lastname, birth_date, phone, email, street, zip_code, city)
SELECT '223e4567-e89b-12d3-a456-426614174012','FEMALE','Sophia','Clark','1991-12-25',
       '+49 911 1230987','sophia.clark@example.com','123 Hickory St','90766','Shelbyville'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id='223e4567-e89b-12d3-a456-426614174012');

-- Capital City (Erlangen area)
INSERT INTO patient (id, gender, firstname, lastname, birth_date, phone, email, street, zip_code, city)
SELECT '123e4567-e89b-12d3-a456-426614174002','FEMALE','Alice','Johnson','1978-03-12',
       '+49 9131 234567','alice.johnson@example.com','789 Oak St','91052','Capital City'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id='123e4567-e89b-12d3-a456-426614174002');

INSERT INTO patient (id, gender, firstname, lastname, birth_date, phone, email, street, zip_code, city)
SELECT '223e4567-e89b-12d3-a456-426614174007','MALE','David','Wilson','1975-01-11',
       '+49 9131 345678','david.wilson@example.com','456 Ash St','91054','Capital City'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id='223e4567-e89b-12d3-a456-426614174007');

INSERT INTO patient (id, gender, firstname, lastname, birth_date, phone, email, street, zip_code, city)
SELECT '223e4567-e89b-12d3-a456-426614174010','FEMALE','Emma','Moore','1980-08-09',
       '+49 9131 456789','emma.moore@example.com','654 Spruce St','91056','Capital City'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id='223e4567-e89b-12d3-a456-426614174010');

INSERT INTO patient (id, gender, firstname, lastname, birth_date, phone, email, street, zip_code, city)
SELECT '223e4567-e89b-12d3-a456-426614174013','MALE','Daniel','Lewis','1976-06-08',
       '+49 9131 567890','daniel.lewis@example.com','456 Cypress St','91058','Capital City'
WHERE NOT EXISTS (SELECT 1 FROM patient WHERE id='223e4567-e89b-12d3-a456-426614174013');
