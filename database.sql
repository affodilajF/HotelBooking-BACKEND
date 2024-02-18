CREATE DATABASE hotel_booking_backend;

USE hotel_booking_backend;

CREATE TABLE Users
(
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
    token VARCHAR(100) NULL,
    token_expired_at BIGINT,
    PRIMARY KEY (username),
    UNIQUE (token)
) ENGINE InnoDB;
#     unique akan secara otomatis menambahkan index ke token


# create table yang laen disini










