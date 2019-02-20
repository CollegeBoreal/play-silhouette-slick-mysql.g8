# products schema

# --- !Ups

CREATE TABLE products (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '	',
  `sku` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`)
);

# --- !Downs

DROP TABLE products;
