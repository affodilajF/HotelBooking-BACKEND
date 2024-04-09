CREATE DATABASE hotel_booking_backend;

USE hotel_booking_backend;

CREATE TABLE Users
                (
                    user_id VARCHAR(255) NOT NULL,
                    username VARCHAR(100) NOT NULL,
                    password VARCHAR(100) NOT NULL,
                    name VARCHAR(100) NOT NULL,
                    token VARCHAR(100) NULL,
                    token_expired_at BIGINT,
                    PRIMARY KEY (user_id),
                    UNIQUE (token),
                    INDEX (token) -- Menambahkan indeks pada kolom token
                ) ENGINE InnoDB;


# create table yang laen disini
desc Users;

CREATE TABLE Accommodation
(
    name VARCHAR(100) NOT NULL
) ENGINE InnoDB;










