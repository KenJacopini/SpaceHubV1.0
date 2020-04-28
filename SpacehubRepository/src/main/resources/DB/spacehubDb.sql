-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema spacehub
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `spacehub` ;

-- -----------------------------------------------------
-- Schema spacehub
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `spacehub` DEFAULT CHARACTER SET utf8 ;
USE `spacehub` ;

-- -----------------------------------------------------
-- Table `spacehub`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spacehub`.`status` (
  `status_id` INT(11) NULL,
  `status_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`status_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spacehub`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spacehub`.`product` (
  `product_id` INT(11) NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(45) NULL DEFAULT NULL,
  `product_plan` VARCHAR(45) NULL DEFAULT NULL,
  `product_price` DOUBLE NULL DEFAULT NULL,
  `product_image` VARCHAR(100) NULL DEFAULT NULL,
  `status_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`product_id`),
  INDEX `fk_product_status1_idx` (`status_name` ASC),
  CONSTRAINT `fk_product_status1`
    FOREIGN KEY (`status_name`)
    REFERENCES `spacehub`.`status` (`status_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spacehub`.`spacehub_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spacehub`.`spacehub_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(150) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `phone_number` VARCHAR(45) NULL DEFAULT NULL,
  `company_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `index2` (`email` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spacehub`.`booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spacehub`.`booking` (
  `book_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `phone_number` VARCHAR(45) NULL DEFAULT NULL,
  `check_in` DATE NULL DEFAULT NULL,
  `check_out` DATE NULL,
  `company_name` VARCHAR(45) NULL,
  `spacehub_user_id` INT(11) NOT NULL,
  `product_id` INT(11) NOT NULL,
  PRIMARY KEY (`book_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `fk_spacehubBooking_spacehub_user1_idx` (`spacehub_user_id` ASC),
  INDEX `fk_spacehubBooking_product1_idx` (`product_id` ASC),
  CONSTRAINT `fk_spacehubBooking_spacehub_user1`
    FOREIGN KEY (`spacehub_user_id`)
    REFERENCES `spacehub`.`spacehub_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_spacehubBooking_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `spacehub`.`product` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spacehub`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spacehub`.`roles` (
  `role_id` INT(11) NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spacehub`.`roles_has_spacehub_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `spacehub`.`roles_has_spacehub_user` (
  `roles_role_id` INT(11) NOT NULL,
  `spacehub_user_id` INT(11) NOT NULL,
  PRIMARY KEY (`roles_role_id`, `spacehub_user_id`),
  INDEX `fk_roles_has_spacehub_user_spacehub_user1_idx` (`spacehub_user_id` ASC),
  INDEX `fk_roles_has_spacehub_user_roles1_idx` (`roles_role_id` ASC),
  CONSTRAINT `fk_roles_has_spacehub_user_roles1`
    FOREIGN KEY (`roles_role_id`)
    REFERENCES `spacehub`.`roles` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_roles_has_spacehub_user_spacehub_user1`
    FOREIGN KEY (`spacehub_user_id`)
    REFERENCES `spacehub`.`spacehub_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

