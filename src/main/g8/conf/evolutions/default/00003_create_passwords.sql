# --- passwords schema

# --- !Ups

CREATE TABLE IF NOT EXISTS `PASSWORDS` (
  `providerkey` VARCHAR(45) NOT NULL,
  `hasher` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `salt` VARCHAR(45) NULL,
  PRIMARY KEY (`providerkey`)
);

# --- !Downs

DROP TABLE `PASSWORDS`;
