CREATE TABLE IF NOT EXISTS country_exam (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`country_id` bigint(20) NOT NULL,
	`medical_exam_id` bigint(20) NOT NULL,
	`is_required` double NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY(`country_id`) REFERENCES country (`id`),
	FOREIGN KEY(`medical_exam_id`) REFERENCES medical_exam (`id`)
);
