CREATE TABLE IF NOT EXISTS company_vaccine (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`company_id` bigint(20) NOT NULL,
	`vaccine_id` bigint(20) NOT NULL,
	`price` double NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY(`company_id`) REFERENCES company (`id`),
	FOREIGN KEY(`vaccine_id`) REFERENCES vaccine (`id`)
);
