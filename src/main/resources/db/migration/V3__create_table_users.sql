CREATE TABLE IF NOT EXISTS users (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`name` varchar(100) NOT NULL,
	`email` varchar(120) NOT NULL,
	`phone_number` varchar(120) NOT NULL,
	`cpf` varchar(11) NOT NULL,
	`rg` varchar(9) NOT NULL,
	`address` varchar(255) NOT NULL,
	`password` varchar(255) NOT NULL,
	`role_id` bigint(20) NOT NULL,
	`created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`id`),
	FOREIGN KEY(`role_id`) REFERENCES roles (`id`)
);