DROP DATABASE IF EXISTS book_manager;
CREATE DATABASE book_manager;
USE book_manager;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS rentals;

CREATE TABLE users (
    id bigint NOT NULL,
    email varchar(256) UNIQUE NOT NULL,
    password varchar(128) NOT NULL,
    name varchar(32) NOT NULL,
    role_type enum('ADMIN', 'USER'),
    PRIMARY KEY (id)
) ENGINE = innodb CHARSET = utf8mb4;

CREATE TABLE books (
    id bigint NOT NULL,
    title varchar(128) NOT NULL,
    author varchar(32) NOT NULL,
    release_date date NOT NULL,
    PRIMARY KEY (id)
) ENGINE = innodb CHARSET = utf8mb4;

CREATE TABLE rentals (
    book_id bigint NOT NULL,
    user_id bigint NOT NULL,
    rental_datetime datetime NOT NULL,
    return_deadline datetime NOT NULL,
    PRIMARY KEY (book_id)
) ENGINE = innodb CHARSET = utf8mb4;

INSERT INTO users values
(1, "admin@test.com", "$2y$05$Jd8xzUNWGtH6PCXOuxScBOMlUXzIpGlDOTGIuhdgAfYArpYmVgKsm", "admin", "ADMIN"),
(2, "user@test.com", "$2y$05$E0txhpg8n3Qsh9bFGbd0O.QyWjV3Y7fjRQd8cu13TTpA4hzqMzSvm", "user", "USER");


INSERT INTO books values
(1, "Kotlin入門", "Ichiro", "2020-01-01"),
(2, "Kotlin実践", "Jiro", "2020-02-01"),
(3, "Kotlin応用", "Saburo", "2020-03-01");
