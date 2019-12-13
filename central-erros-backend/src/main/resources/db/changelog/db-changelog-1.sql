-- liquibase formatted sql
-- changeset squad.2:1.0 dbms:mysql
CREATE TABLE IF NOT EXISTS `centralerros`.`user` (
                                                     `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                                                     `name` VARCHAR(255) NOT NULL,
                                                     `password` VARCHAR(255) NOT NULL,
                                                     `email` VARCHAR(255) NOT NULL,
                                                     `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                     `environment` INT NULL,
                                                     `role` INT NULL,
                                                     PRIMARY KEY (`id`),
                                                     UNIQUE INDEX `id_UNIQUE` (`id` ASC) )
    ENGINE = InnoDB;
-- changeset squad.2:1.1 dbms:mysql
CREATE TABLE IF NOT EXISTS `centralerros`.`event` (
                                                      `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                                                      `description` VARCHAR(255) NOT NULL,
                                                      `source` VARCHAR(255) NOT NULL,
                                                      `details` VARCHAR(255) NOT NULL,
                                                      `status` INT NOT NULL,
                                                      `environment` INT NOT NULL,
                                                      `level` INT NOT NULL,
                                                      `category` INT NOT NULL,
                                                      `create_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                      `user_id` BIGINT(20) NOT NULL,
                                                      PRIMARY KEY (`id`),
                                                      UNIQUE INDEX `id_UNIQUE` (`id` ASC) ,
                                                      INDEX `fk_event_user_idx` (`user_id` ASC) ,
                                                      CONSTRAINT `fk_event_user`
                                                          FOREIGN KEY (`user_id`)
                                                              REFERENCES `centralerros`.`user` (`id`)
                                                              ON DELETE NO ACTION
                                                              ON UPDATE NO ACTION)
    ENGINE = InnoDB;