CREATE TABLE IF NOT EXISTS address (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(255),
    city VARCHAR(255),
    street VARCHAR(255),
    apartment VARCHAR(255),
    postal_code VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS department (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    num_of_emp INT
);

CREATE TABLE IF NOT EXISTS employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    surname VARCHAR(255),
    age INT,
    address_id BIGINT,
    department_id BIGINT,
    FOREIGN KEY (address_id) REFERENCES address (id),
    FOREIGN KEY (department_id) REFERENCES department (id)
);
