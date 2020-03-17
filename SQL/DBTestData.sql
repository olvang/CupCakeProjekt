set foreign_key_checks=0;
TRUNCATE TABLE users;
INSERT INTO `olskercupcake`.`users` (`email`,`password`,`balance`) VALUES ('someone@nowhere.com','a1234',100);
INSERT INTO `olskercupcake`.`users` (`email`,`password`,`balance`) VALUES ('jensen@nowhere.com','b1234',0);
INSERT INTO `olskercupcake`.`users` (`email`,`password`,`balance`) VALUES ('pedersen@nowhere.com','c1234',40);
INSERT INTO `olskercupcake`.`users` (`email`,`password`,`balance`) VALUES ('hansen@nowhere.com','d1234',4000);
INSERT INTO `olskercupcake`.`users` (`email`,`password`,`balance`,`admin`) VALUES ('admin@admin.com','admin',100,1);

TRUNCATE TABLE cupcake_bottom;
INSERT INTO `olskercupcake`.`cupcake_bottom` (`cb_price`,`cb_name`) VALUES (5.00,'Chocolate');
INSERT INTO `olskercupcake`.`cupcake_bottom` (`cb_price`,`cb_name`) VALUES (5.00,'Vanilla');
INSERT INTO `olskercupcake`.`cupcake_bottom` (`cb_price`,`cb_name`) VALUES (5.00,'Nutmeg');
INSERT INTO `olskercupcake`.`cupcake_bottom` (`cb_price`,`cb_name`) VALUES (6.00,'Pistacio');
INSERT INTO `olskercupcake`.`cupcake_bottom` (`cb_price`,`cb_name`) VALUES (7.00,'Almond');

TRUNCATE TABLE cupcake_top;
INSERT INTO `olskercupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (5.00,'Chocolate');
INSERT INTO `olskercupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (5.00,'Blueberry');
INSERT INTO `olskercupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (5.00,'Rasberry');
INSERT INTO `olskercupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (6.00,'Crispy');
INSERT INTO `olskercupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (6.00,'Strawberry');
INSERT INTO `olskercupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (7.00,'Rum/Raisin');
INSERT INTO `olskercupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (8.00,'Orange');
INSERT INTO `olskercupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (8.00,'Lemon');
INSERT INTO `olskercupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (9.00,'Blue cheese');

TRUNCATE TABLE orders;
INSERT INTO olskercupcake.orders (u_id,pick_up_date) VALUES (1,'2008-01-01 00:00:01');
INSERT INTO olskercupcake.orders (u_id,pick_up_date) VALUES (2,'2008-01-01 10:00:01');
INSERT INTO olskercupcake.orders (u_id,pick_up_date) VALUES (3,'2008-01-01 20:00:01');
INSERT INTO olskercupcake.orders (u_id,pick_up_date) VALUES (4,'2008-01-01 00:35:01');
INSERT INTO olskercupcake.orders (u_id,pick_up_date) VALUES (4,'2008-01-01 20:35:11');

TRUNCATE TABLE order_line;
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,1,1,1);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,1,2,1);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,2,2,4);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,3,5,4);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,3,9,1);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,4,2,5);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,4,9,5);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,4,3,2);

set foreign_key_checks=1;