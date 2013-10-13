SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

ALTER TABLE `Share` DROP FOREIGN KEY `fk_Share_Portfolio` ;

ALTER TABLE `Share` DROP COLUMN `idPortfolio`
, DROP INDEX `fk_Share_Portfolio` ;

ALTER TABLE `ShareQuantity` ADD COLUMN `idPortfolio` INT(11) NOT NULL  AFTER `idShare` ,
  ADD CONSTRAINT `fk_ShareQuantity_Portfolio`
  FOREIGN KEY (`idPortfolio` )
  REFERENCES `Portfolio` (`idPortfolio` )
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
, DROP INDEX `fk_ShareQuantity_Share`
, ADD INDEX `fk_ShareQuantity_Share_idx` (`idShare` ASC)
, ADD INDEX `fk_ShareQuantity_Portfolio_idx` (`idPortfolio` ASC) ;

ALTER TABLE `ShareValue`
DROP INDEX `fk_ShareValue_Share`
, ADD INDEX `fk_ShareValue_Share_idx` (`idShare` ASC) ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
