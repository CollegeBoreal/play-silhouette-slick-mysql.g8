# artists schema

# --- !Ups

CREATE TABLE `USERS` (
  `user` BIGINT(20) NOT NULL,
  `number` VARCHAR(45) NULL,
  `providerKey` VARCHAR(45) NULL,
  `active` TINYINT(1) NULL,
  `created` TIMESTAMP NULL
  PRIMARY KEY (`user`),
  INDEX `fk_USERS_LOGINS1_idx` (`providerKey` ASC) VISIBLE,
  CONSTRAINT `fk_USERS_LOGINS1`
    FOREIGN KEY (`providerKey`)
    REFERENCES `LOGINS` (`providerKey`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    );

# --- !Downs

DROP TABLE `USERS`;
