SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

ALTER TABLE `shareplot`.`ShareQuantity` DROP FOREIGN KEY `fk_ShareQuantity_Share` ;

ALTER TABLE `shareplot`.`ShareValue` DROP FOREIGN KEY `fk_ShareValue_Share` ;

ALTER TABLE `shareplot`.`Share` ADD COLUMN `idPortfolio` INT(11) NOT NULL  AFTER `idShare` , 
  ADD CONSTRAINT `fk_Share_Portfolio`
  FOREIGN KEY (`idPortfolio` )
  REFERENCES `shareplot`.`Portfolio` (`idPortfolio` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, ADD INDEX `fk_Share_Portfolio` (`idPortfolio` ASC) ;

ALTER TABLE `shareplot`.`ShareQuantity` ADD COLUMN `shareValue` DECIMAL(12,2) NOT NULL  AFTER `changeType` , ADD COLUMN `changeFee` DECIMAL(12,2) NOT NULL  AFTER `shareValue` , ADD COLUMN `shareQuantity` DECIMAL(12,2) NOT NULL  AFTER `changeFee` , 
  ADD CONSTRAINT `fk_ShareQuantity_Share`
  FOREIGN KEY (`idShare` )
  REFERENCES `shareplot`.`Share` (`idShare` )
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `shareplot`.`ShareValue` 
  ADD CONSTRAINT `fk_ShareValue_Share`
  FOREIGN KEY (`isShare` )
  REFERENCES `shareplot`.`Share` (`idShare` )
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

CREATE  TABLE IF NOT EXISTS `shareplot`.`Portfolio` (
  `idPortfolio` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `isFake` CHAR(1) NOT NULL ,
  PRIMARY KEY (`idPortfolio`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
