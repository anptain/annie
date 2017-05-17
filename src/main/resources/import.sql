DROP TABLE IF EXISTS `an_user`;

CREATE TABLE `an_user` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `username` VARCHAR(50),
  `password` VARCHAR(30),
  `deleted` BIT,
  `version` INT,
  `created_by` INT,
  `created_date` DATETIME,
  `last_modified_by` INT,
  `last_modified_date` DATETIME
);

INSERT INTO `an_user`(`username`,`password`,`deleted`,`version`,`created_by`,`created_date`,`last_modified_by`,`last_modified_date`) VALUES ('admin','admin',0,0,1,NOW(),1,NOW());