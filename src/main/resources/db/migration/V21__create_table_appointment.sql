CREATE TABLE IF NOT EXISTS appointment (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`status` varchar(20) NOT NULL,
	`country_id` bigint(20) NOT NULL,
	`user_id` bigint(20) NOT NULL,
	`only_required` TINYINT(1) NOT NULL,
	`schedule_date` TIMESTAMP NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY(`country_id`) REFERENCES country (`id`),
	FOREIGN KEY(`user_id`) REFERENCES users (`id`)
);
