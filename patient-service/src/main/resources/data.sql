-- PRINCIPAL TABLE
CREATE TABLE IF NOT EXISTS patient (
    id                 UUID PRIMARY KEY,
    registration_date  TIMESTAMP,
    last_update_date   TIMESTAMP,
    gender             VARCHAR(10)  NOT NULL,
    firstname          VARCHAR(100) NOT NULL,
    lastname           VARCHAR(100) NOT NULL,
    birth_date         DATE         NOT NULL,
    email              VARCHAR(255) UNIQUE NOT NULL,
    street             VARCHAR(255) NOT NULL,
    zip_code           VARCHAR(20)  NOT NULL,
    city               VARCHAR(100) NOT NULL
    );

-- PHONE NUMBER TABLE
CREATE TABLE IF NOT EXISTS patient_phone (
                                             patient_id   UUID        NOT NULL,
                                             number       VARCHAR(30) NOT NULL,
    type         VARCHAR(10) NOT NULL,
    PRIMARY KEY (patient_id, number),
    FOREIGN KEY (patient_id) REFERENCES patient(id) ON DELETE CASCADE
    );

-- === PATIENTS ===
INSERT INTO patient
(id, registration_date, last_update_date, gender, firstname, lastname,
 birth_date, email, street, zip_code, city)
VALUES
    ('123e4567-e89b-12d3-a456-426614174000', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
     'MALE', 'John', 'Doe', '1985-06-15', 'john.doe@example.com',
     '123 Main St', '90402', 'Nürnberg'),

    ('123e4567-e89b-12d3-a456-426614174001', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
     'FEMALE', 'Jane', 'Smith', '1990-09-23', 'jane.smith@example.com',
     '456 Elm St', '90403', 'Nürnberg'),

    ('123e4567-e89b-12d3-a456-426614174002', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
     'FEMALE', 'Alice', 'Johnson', '1978-03-12', 'alice.johnson@example.com',
     '789 Oak St', '90404', 'Nürnberg'),
    ('123e4567-e89b-12d3-a456-426614174003', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
     'MALE', 'Bob', 'Brown', '1982-11-30', 'bob.brown@example.com',
     '321 Pine St', '90405', 'Nürnberg'),

    ('123e4567-e89b-12d3-a456-426614174004', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
     'FEMALE', 'Emily', 'Davis', '1995-02-05', 'emily.davis@example.com',
     '654 Maple St', '90406', 'Nürnberg'),

    ('223e4567-e89b-12d3-a456-426614174005', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
     'MALE', 'Michael', 'Green', '1988-07-25', 'michael.green@example.com',
     '987 Cedar St', '90407', 'Nürnberg'),

    ('223e4567-e89b-12d3-a456-426614174006', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
     'FEMALE', 'Sarah', 'Taylor', '1992-04-18', 'sarah.taylor@example.com',
     '123 Birch St', '90408', 'Nürnberg'),

    ('223e4567-e89b-12d3-a456-426614174007', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
     'MALE', 'David', 'Wilson', '1975-01-11', 'david.wilson@example.com',
     '456 Ash St', '90409', 'Nürnberg'),

    ('223e4567-e89b-12d3-a456-426614174008', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
     'FEMALE', 'Laura', 'White', '1989-09-02', 'laura.white@example.com',
     '789 Palm St', '90410', 'Nürnberg'),

    ('223e4567-e89b-12d3-a456-426614174009', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
     'MALE', 'James', 'Harris', '1993-11-15', 'james.harris@example.com',
     '321 Cherry St', '90411', 'Nürnberg'),

    ('223e4567-e89b-12d3-a456-426614174010', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
     'FEMALE', 'Emma', 'Moore', '1980-08-09', 'emma.moore@example.com',
     '654 Spruce St', '90412', 'Nürnberg'),

    ('223e4567-e89b-12d3-a456-426614174011', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
     'MALE', 'Ethan', 'Martinez', '1984-05-03', 'ethan.martinez@example.com',
     '987 Redwood St', '90413', 'Nürnberg'),

    ('223e4567-e89b-12d3-a456-426614174012', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
     'FEMALE', 'Sophia', 'Clark', '1991-12-25', 'sophia.clark@example.com',
     '123 Hickory St', '90414', 'Nürnberg'),

    ('223e4567-e89b-12d3-a456-426614174013', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
     'MALE', 'Daniel', 'Lewis', '1976-06-08', 'daniel.lewis@example.com',
     '456 Cypress St', '90415', 'Nürnberg'),

    ('223e4567-e89b-12d3-a456-426614174014', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
     'FEMALE', 'Isabella', 'Walker', '1987-10-17', 'isabella.walker@example.com',
     '789 Willow St', '90416', 'Nürnberg');

-- === PHONES ===
INSERT INTO patient_phone (patient_id, number, type) VALUES
    ('123e4567-e89b-12d3-a456-426614174000', '+49 911 1234567', 'MOBILE'),
    ('123e4567-e89b-12d3-a456-426614174000', '+49 911 7654321', 'PRIVATE'),

    ('123e4567-e89b-12d3-a456-426614174001', '+49 911 2223344', 'MOBILE'),

    ('123e4567-e89b-12d3-a456-426614174002', '+49 911 3334455', 'MOBILE'),
    ('123e4567-e89b-12d3-a456-426614174002', '+49 911 5556677', 'OTHER'),

    ('123e4567-e89b-12d3-a456-426614174003', '+49 911 4447788', 'MOBILE'),
    ('123e4567-e89b-12d3-a456-426614174003', '+49 911 4447799', 'PRIVATE'),

    ('123e4567-e89b-12d3-a456-426614174004', '+49 911 5558899', 'MOBILE'),
    ('123e4567-e89b-12d3-a456-426614174004', '+49 911 5558800', 'OTHER'),

    ('223e4567-e89b-12d3-a456-426614174005', '+49 911 6669900', 'MOBILE'),
    ('223e4567-e89b-12d3-a456-426614174005', '+49 911 6669911', 'PRIVATE'),

    ('223e4567-e89b-12d3-a456-426614174006', '+49 911 7770011', 'MOBILE'),
    ('223e4567-e89b-12d3-a456-426614174006', '+49 911 7770022', 'OTHER'),

    ('223e4567-e89b-12d3-a456-426614174007', '+49 911 8881122', 'MOBILE'),
    ('223e4567-e89b-12d3-a456-426614174007', '+49 911 8881133', 'PRIVATE'),

    ('223e4567-e89b-12d3-a456-426614174008', '+49 911 9992233', 'MOBILE'),
    ('223e4567-e89b-12d3-a456-426614174008', '+49 911 9992244', 'OTHER'),

    ('223e4567-e89b-12d3-a456-426614174009', '+49 911 1113344', 'MOBILE'),
    ('223e4567-e89b-12d3-a456-426614174009', '+49 911 1113355', 'PRIVATE'),

    ('223e4567-e89b-12d3-a456-426614174010', '+49 911 2224455', 'MOBILE'),
    ('223e4567-e89b-12d3-a456-426614174010', '+49 911 2224466', 'OTHER'),

    ('223e4567-e89b-12d3-a456-426614174011', '+49 911 3335566', 'MOBILE'),
    ('223e4567-e89b-12d3-a456-426614174011', '+49 911 3335577', 'PRIVATE'),

    ('223e4567-e89b-12d3-a456-426614174012', '+49 911 4446677', 'MOBILE'),
    ('223e4567-e89b-12d3-a456-426614174012', '+49 911 4446688', 'OTHER'),

    ('223e4567-e89b-12d3-a456-426614174013', '+49 911 5557788', 'MOBILE'),
    ('223e4567-e89b-12d3-a456-426614174013', '+49 911 5557799', 'PRIVATE'),

    ('223e4567-e89b-12d3-a456-426614174014', '+49 911 6668899', 'MOBILE'),
    ('223e4567-e89b-12d3-a456-426614174014', '+49 911 6668800', 'OTHER');
