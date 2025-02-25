DROP DATABASE IF EXISTS `OlskerCupcake`;
CREATE SCHEMA `OlskerCupcake`;
USE OlskerCupcake;
SET SQL_MODE =  'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION';

CREATE TABLE `cupcake_top` (
  `cp_id` int PRIMARY KEY AUTO_INCREMENT,
  `cp_price` double NOT NULL,
  `cp_name` VARCHAR(45) UNIQUE NOT NULL
);
CREATE TABLE `cupcake_bottom` (
  `cb_id` int PRIMARY KEY AUTO_INCREMENT,
  `cb_price` double NOT NULL,
  `cb_name` VARCHAR(45) UNIQUE NOT NULL
);
CREATE TABLE `users` (
  `u_id` int PRIMARY KEY AUTO_INCREMENT,
  `password` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) UNIQUE NOT NULL,
  `admin` tinyint NOT NULL default 0,
  `balance` double NOT NULL,
  `created_at` timestamp default CURRENT_TIMESTAMP
);
CREATE TABLE `orders` (
  `o_id` int PRIMARY KEY AUTO_INCREMENT,
  `u_id` int NOT NULL,
  `pick_up_date`DATE not null,
  `price` double not null,
  `created_at` timestamp default CURRENT_TIMESTAMP,
  CONSTRAINT orders_fkey
		FOREIGN KEY (`u_id`) 
		REFERENCES users(`u_id`)
		ON DELETE CASCADE
);
CREATE TABLE `order_line` (
  `ol_id` int PRIMARY KEY AUTO_INCREMENT,
  `o_id` int not null,
  `cp_id` int NOT NULL,
   `cb_id` int NOT NULL,
  `amount` int NOT NULL,
	 CONSTRAINT order_line_fkey
		FOREIGN KEY (`o_id`) 
		REFERENCES orders(`o_id`)
		ON DELETE CASCADE,
        CONSTRAINT order_line_cp_key
		FOREIGN KEY (`cp_id`) 
		REFERENCES cupcake_top(`cp_id`),
        CONSTRAINT order_line_cb_key
		FOREIGN KEY (`cb_id`) 
		REFERENCES cupcake_bottom(`cb_id`)
);