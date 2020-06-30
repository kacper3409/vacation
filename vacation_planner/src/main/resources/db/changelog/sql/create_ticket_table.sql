--liquibase formatted sql

create table ticket (
    id bigserial not null primary key unique,
    title VARCHAR (255),
    description varchar (255),
    days_count BIGINT,
    ticket_status VARCHAR (255),
    active BOOLEAN,
    creator_id BIGINT,
    manager_id BIGINT,
    type varchar(255),
    creation_date date,
    update_date date,
    update_by_id bigint
);
