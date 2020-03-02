USE codetestdb;

DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`full_name` VARCHAR(50) NOT NULL,
`total_loan` DOUBLE NOT NULL,
`annual_interest_rate` DOUBLE NOT NULL,
`monthly_interest_decimal` DOUBLE NOT NULL,
`monthly_interest_rate` DOUBLE NOT NULL,
`number_payments` DOUBLE NOT NULL,
`years` DOUBLE NOT NULL
);