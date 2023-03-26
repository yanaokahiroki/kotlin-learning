DROP DATABASE IF EXISTS kotlin;
CREATE DATABASE kotlin;
USE kotlin;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id int(10) NOT NULL,
    name varchar(16) NOT NULL,
    age int(10) NOT NULL,
    profile varchar(64) NOT NULL,
    PRIMARY KEY (id)
) ENGINE = innodb CHARSET = utf8mb4;

INSERT INTO users values
(100, "Ichiro", 30, "Hello"),
(101, "Jiro", 25, "Hello"),
(102, "Saburo", 20, "Hello");
