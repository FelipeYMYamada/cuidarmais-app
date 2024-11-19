CREATE TABLE IF NOT EXISTS company (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`name` varchar(100) NOT NULL,
	`cnpj` varchar(14) NOT NULL,
	PRIMARY KEY (`id`)
);