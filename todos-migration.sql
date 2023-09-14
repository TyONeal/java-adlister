CREATE DATABASE IF NOT EXISTS todos_db;
USE todos_db;

DROP TABLE todos;

CREATE TABLE IF NOT EXISTS todos (
    name VARCHAR(100) NOT NULL,
    isComplete boolean NOT NULL
);