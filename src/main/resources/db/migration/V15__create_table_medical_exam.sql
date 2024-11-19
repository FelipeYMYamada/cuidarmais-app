CREATE TABLE IF NOT EXISTS medical_exam (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`name` varchar(100) NOT NULL,
	`description` TEXT NOT NULL,
	PRIMARY KEY (`id`)
);
