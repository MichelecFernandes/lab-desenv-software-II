DROP TABLE IF EXISTS user_model;
DROP TABLE IF EXISTS product;
DROP TYPE IF EXISTS user_role;

CREATE TYPE user_role AS ENUM ('ADMINISTRATOR', 'USER');

CREATE TABLE user_model
(
    id       SERIAL     not null,
    email    varchar(50) not null,
    fullname varchar(50) not null,
    password varchar(60) not null,
    role user_role NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE product
(
    id       SERIAL     not null,
    name    varchar(50) not null,
    price double precision,
    PRIMARY KEY (id)
);

