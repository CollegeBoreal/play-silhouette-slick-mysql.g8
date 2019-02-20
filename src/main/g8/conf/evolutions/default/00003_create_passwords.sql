# passwords schema

# --- !Ups

CREATE TABLE IF NOT EXISTS `PASSWORDS` (
  `providerKey` BIGINT(20) NOT NULL,
  `hasher` TEXT NULL,
  `password` TEXT NULL,
  `salt` VARCHAR(255) NULL,
  PRIMARY KEY (`providerKey`),
  CONSTRAINT `LOGINS`
    FOREIGN KEY (`providerKey`)
    REFERENCES `LOGINS` (`providerKey`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

# --- !Downs

DROP TABLE passwords;
