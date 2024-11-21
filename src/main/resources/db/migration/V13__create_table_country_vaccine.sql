CREATE TABLE IF NOT EXISTS country_vaccine (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`country_id` bigint(20) NOT NULL,
	`vaccine_id` bigint(20) NOT NULL,
	`is_required` TINYINT(1) NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY(`country_id`) REFERENCES country (`id`),
	FOREIGN KEY(`vaccine_id`) REFERENCES vaccine (`id`)
);
