-- liquibase formatted sql
-- changeset squad.2:2.0 dbms:mysql
SET FOREIGN_KEY_CHECKS = 0;
INSERT INTO user (name, email, password, created_at, profile)
VALUES ('Administrador', 'admin@centralerros.com.br', 'admin123', '2019-11-30 16:52:21', '1');
SET FOREIGN_KEY_CHECKS = 1;