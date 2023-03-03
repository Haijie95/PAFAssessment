CREATE SCHEMA `acme_bank` ;

CREATE TABLE `acme_bank`.`accounts` (
  `account_id` VARCHAR(10) NOT NULL,
  `name` VARCHAR(128) NOT NULL,
  `balance` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`account_id`));

insert into accounts values ("V9L3Jd1BBI","fred",100.00);
insert into accounts values ("fhRq46Y6vB","barney",300.00);
insert into accounts values ("uFSFRqUpJy","wilma",1000.00);
insert into accounts values ("ckTV56axff","betty",1000.00);
insert into accounts values ("Qgcnwbshbh","pebbles",50.00);
insert into accounts values ("if9l185l18","bambam",50.00);
