-- liquibase formatted sql
-- changeset squad.2:1.0 dbms:mysql
set foreign_key_checks=0;

CREATE TABLE application (
                             id bigint(20) NOT NULL AUTO_INCREMENT,
                             name varchar(255) NOT NULL,
                             created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                             business_unit int(11) NOT NULL,
                             PRIMARY KEY (id)
) ENGINE=InnoDB;

set foreign_key_checks=1;

-- changeset squad.2:1.1 dbms:mysql

set foreign_key_checks=0;

CREATE TABLE categorory (
                            id bigint(20) NOT NULL AUTO_INCREMENT,
                            name varchar(45) NOT NULL,
                            PRIMARY KEY (id)
) ENGINE=InnoDB;

set foreign_key_checks=1;

-- changeset squad.2:1.2 dbms:mysql

set foreign_key_checks=0;

CREATE TABLE enviroment (
                            id bigint(20) NOT NULL,
                            name varchar(45) NOT NULL,
                            PRIMARY KEY (id)
) ENGINE=InnoDB;

set foreign_key_checks=1;

-- changeset squad.2:1.3 dbms:mysql

set foreign_key_checks=0;

CREATE TABLE event (
                       id bigint(20) NOT NULL AUTO_INCREMENT,
                       description text NOT NULL,
                       source varchar(45) NOT NULL,
                       created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                       enviroment_id bigint(20) NOT NULL,
                       level_id bigint(20) NOT NULL,
                       category_id bigint(20) NOT NULL,
                       details text NOT NULL,
                       status_id bigint(20) NOT NULL,
                       PRIMARY KEY (id),
                       KEY fk_event_level_idx (level_id),
                       KEY fk_event_enviroment_idx (enviroment_id),
                       KEY fk_event_status_idx (status_id),
                       KEY fk_event_category_idx (category_id),
                       CONSTRAINT fk_event_category FOREIGN KEY (category_id) REFERENCES categorory (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
                       CONSTRAINT fk_event_enviroment FOREIGN KEY (enviroment_id) REFERENCES enviroment (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
                       CONSTRAINT fk_event_level FOREIGN KEY (level_id) REFERENCES level (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
                       CONSTRAINT fk_event_status FOREIGN KEY (status_id) REFERENCES status (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

set foreign_key_checks=1;

-- changeset squad.2:1.4 dbms:mysql

set foreign_key_checks=0;

CREATE TABLE level (
                       id bigint(20) NOT NULL AUTO_INCREMENT,
                       name varchar(45) NOT NULL,
                       PRIMARY KEY (id)
) ENGINE=InnoDB;

set foreign_key_checks=1;

-- changeset squad.2:1.5 dbms:mysql

set foreign_key_checks=0;

CREATE TABLE role (
                      id bigint(20) NOT NULL AUTO_INCREMENT,
                      name varchar(45) NOT NULL,
                      PRIMARY KEY (id)
) ENGINE=InnoDB;

set foreign_key_checks=1;

-- changeset squad.2:1.6 dbms:mysql

set foreign_key_checks=0;

CREATE TABLE status (
                        id bigint(20) NOT NULL AUTO_INCREMENT,
                        name varchar(45) NOT NULL,
                        PRIMARY KEY (id)
) ENGINE=InnoDB;

set foreign_key_checks=1;

-- changeset squad.2:1.7 dbms:mysql

set foreign_key_checks=0;

CREATE TABLE user (
                      id bigint(20) NOT NULL AUTO_INCREMENT,
                      name varchar(255) NOT NULL,
                      email varchar(255) NOT NULL,
                      password varchar(255) NOT NULL,
                      enviroment_id bigint(20) DEFAULT NULL,
                      role_id bigint(20) DEFAULT NULL,
                      created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                      profile int(11) NOT NULL,
                      last_login timestamp NULL DEFAULT NULL,
                      PRIMARY KEY (id),
                      UNIQUE KEY email_UNIQUE (email),
                      KEY fk_user_role_idx (role_id),
                      KEY fk_user_enviroment_idx (enviroment_id),
                      CONSTRAINT fk_user_enviroment FOREIGN KEY (enviroment_id) REFERENCES enviroment (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
                      CONSTRAINT fk_user_role FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

set foreign_key_checks=1;

-- changeset squad.2:1.8 dbms:mysql

set foreign_key_checks=0;

CREATE TABLE user_application (
                                  id bigint(20) NOT NULL AUTO_INCREMENT,
                                  user_id bigint(20) NOT NULL,
                                  application_id bigint(20) NOT NULL,
                                  PRIMARY KEY (id),
                                  KEY fk_user_application_user_idx (application_id),
                                  KEY fk_user_application_user_idx1 (user_id),
                                  CONSTRAINT fk_user_application_application FOREIGN KEY (application_id) REFERENCES application (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB;

set foreign_key_checks=1;