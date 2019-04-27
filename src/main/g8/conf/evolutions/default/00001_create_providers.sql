# --- providers schema

# --- !Ups
CREATE TABLE IF NOT EXISTS `PROVIDERS` (
  `providerId` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`providerId`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC)
);

# --- !Downs

DROP TABLE `PROVIDERS`;
