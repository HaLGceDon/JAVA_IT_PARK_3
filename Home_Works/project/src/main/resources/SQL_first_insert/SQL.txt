
CREATE TABLE public.users
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    age INTEGER,
    surname VARCHAR(50),
    login VARCHAR(50),
    password VARCHAR(50),
    email VARCHAR(50)
);


CREATE TABLE public.dogs
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    age INTEGER,
    breed VARCHAR(50),
    weight INTEGER,
    color VARCHAR(50),
    health VARCHAR(50)
);


CREATE TABLE public.cats
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    age INTEGER,
    breed VARCHAR(50),
    weight INTEGER,
    color VARCHAR(50),
    health VARCHAR(50)
);