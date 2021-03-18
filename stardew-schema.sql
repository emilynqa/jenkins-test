
DROP TABLE IF EXISTS `villager` CASCADE;
CREATE TABLE villager (


	id BIGINT AUTO_INCREMENT,
	name VARCHAR(255),
	birth_day INTEGER NOT NULL,
	birth_season VARCHAR(255),
	fave_item VARCHAR(255),
	least_fave_item VARCHAR(255),
	PRIMARY KEY (id)
);