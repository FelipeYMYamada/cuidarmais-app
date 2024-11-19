CREATE TABLE IF NOT EXISTS company_exam (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`company_id` bigint(20) NOT NULL,
	`medical_exam_id` bigint(20) NOT NULL,
	`price` double NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY(`company_id`) REFERENCES company (`id`),
	FOREIGN KEY(`medical_exam_id`) REFERENCES medical_exam (`id`)
);
