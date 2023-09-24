-- MySQL Script generated by MySQL Workbench
-- Tue Jun 13 12:01:43 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema onepostdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `simpledb` ;

-- -----------------------------------------------------
-- Schema onepostdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `simpledb` DEFAULT CHARACTER SET utf8 ;
USE `simpledb` ;

-- -----------------------------------------------------
-- Table `simpledb`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `simpledb`.`Users` ;

CREATE TABLE IF NOT EXISTS `simpledb`.`Users` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `role` VARCHAR(200) NOT NULL,
  `enabled` TINYINT NULL,
  `creation` DATETIME NULL DEFAULT NOW(),
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `idUserAccount_UNIQUE` (`user_id` ASC) VISIBLE)
ENGINE = InnoDB;

use simpledb;
INSERT INTO Users (name, username, password, email, role, enabled)
Values
('Tom', 'admin1', '$2a$10$F479UGPamA.N5WgsdVRdruTaQfTqSfOyPpH1g4/r407b2yVjd97xm', 'admin1@company.com', 'ROLE_ADMIN', 1),
('Harry', 'user1', '$2a$10$.3tos13bJ126vWNhP9ftbOZADDAMSzlD2uUtFWDoHVUbBqbvWVj1m', 'user1@company.com', 'ROLE_USER', 1),
('John', 'manager1', '$2a$10$K3GU6gHUlMR0/4jwocyQseLh03Q6LN2zpG57YHsIG.X8PqNgM02SS', 'manager1@company.com', 'ROLE_MANAGER', 1);