CREATE TABLE users
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    surname VARCHAR(50),
    login VARCHAR(50),
    password VARCHAR(50),
    email VARCHAR(50)
);