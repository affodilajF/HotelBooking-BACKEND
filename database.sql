CREATE DATABASE hotel_booking_backend;

USE hotel_booking_backend;

CREATE TABLE Users
(
    user_id BINARY(16) NOT NULL,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(100) NOT NULL,
#     kalo blom login, maka null
    token VARCHAR(100) NULL,
#     ms
    token_expired_at BIGINT,
    PRIMARY KEY (user_id),
    UNIQUE (token)
) ENGINE InnoDB;
#     unique akan secara otomatis menambahkan index ke kolom token


# create table yang laen disini

desc Users;

CREATE TABLE Accommodation
(
    name VARCHAR(100) NOT NULL
) ENGINE InnoDB;










