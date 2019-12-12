-- liquibase formatted sql
-- changeset squad.3:1.0 dbms:mysql
INSERT INTO category (name) VALUES ("NullPointer");
-- changeset squad.3:1.1 dbms:mysql
INSERT INTO category (name) VALUES ("NotFound");
-- changeset squad.3:1.2 dbms:mysql
INSERT INTO category (name) VALUES ("NotAuthorazed");
-- changeset squad.3:1.3 dbms:mysql
INSERT INTO category (name) VALUES ("IlegalStatement");

