--liquibase formatted sql

create table "user" (
    id bigserial not null primary key unique,
    user_name VARCHAR (255) unique not null,
    email varchar (255),
    manager_id BIGINT,
    user_role VARCHAR (255)
);
