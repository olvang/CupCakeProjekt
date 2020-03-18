set foreign_key_checks=0;
TRUNCATE TABLE users;
TRUNCATE TABLE cupcake_bottom;
TRUNCATE TABLE cupcake_top;
TRUNCATE TABLE orders;
TRUNCATE TABLE order_line;
set foreign_key_checks=1;
INSERT INTO `olskercupcake`.`users` (`email`,`password`,`balance`) VALUES ('someone@nowhere.com','a1234',100);
INSERT INTO `olskercupcake`.`users` (`email`,`password`,`balance`) VALUES ('jensen@nowhere.com','b1234',0);
INSERT INTO `olskercupcake`.`users` (`email`,`password`,`balance`) VALUES ('pedersen@nowhere.com','c1234',40);
INSERT INTO `olskercupcake`.`users` (`email`,`password`,`balance`) VALUES ('hansen@nowhere.com','d1234',4000);
INSERT INTO `olskercupcake`.`users` (`email`,`password`,`balance`,`admin`) VALUES ('admin@admin.com','admin',100,1);


INSERT INTO `olskercupcake`.`cupcake_bottom` (`cb_price`,`cb_name`) VALUES (5.00,'Chocolate');
INSERT INTO `olskercupcake`.`cupcake_bottom` (`cb_price`,`cb_name`) VALUES (5.00,'Vanilla');
INSERT INTO `olskercupcake`.`cupcake_bottom` (`cb_price`,`cb_name`) VALUES (5.00,'Nutmeg');
INSERT INTO `olskercupcake`.`cupcake_bottom` (`cb_price`,`cb_name`) VALUES (6.00,'Pistacio');
INSERT INTO `olskercupcake`.`cupcake_bottom` (`cb_price`,`cb_name`) VALUES (7.00,'Almond');


INSERT INTO `olskercupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (5.00,'Chocolate');
INSERT INTO `olskercupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (5.00,'Blueberry');
INSERT INTO `olskercupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (5.00,'Rasberry');
INSERT INTO `olskercupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (6.00,'Crispy');
INSERT INTO `olskercupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (6.00,'Strawberry');
INSERT INTO `olskercupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (7.00,'Rum/Raisin');
INSERT INTO `olskercupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (8.00,'Orange');
INSERT INTO `olskercupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (8.00,'Lemon');
INSERT INTO `olskercupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (9.00,'Blue cheese');

INSERT INTO olskercupcake.orders (u_id,pick_up_date,price,created_at) VALUES (1,'2008-01-01 00:00:01',40.0, '2020-03-18 12:30:56');
INSERT INTO olskercupcake.orders (u_id,pick_up_date,price,created_at) VALUES (1,'2008-01-01 00:00:01',40.0, '2020-03-18 12:30:56');
INSERT INTO olskercupcake.orders (u_id,pick_up_date,price,created_at) VALUES (2,'2008-01-01 10:00:01',55.0, '2020-05-18 11:30:56');
INSERT INTO olskercupcake.orders (u_id,pick_up_date,price,created_at) VALUES (3,'2008-01-01 20:00:01',60.0, '2020-05-18 10:30:56');
INSERT INTO olskercupcake.orders (u_id,pick_up_date,price,created_at) VALUES (4,'2008-01-01 00:35:01',80.0, '2020-04-18 09:30:56');
INSERT INTO olskercupcake.orders (u_id,pick_up_date,price,created_at) VALUES (4,'2008-01-01 00:35:01',80.0, '2020-04-18 08:30:56');
INSERT INTO olskercupcake.orders (u_id,pick_up_date,price,created_at) VALUES (1,'2008-01-01 00:00:01',40.0, '2019-03-18 14:30:56');
INSERT INTO olskercupcake.orders (u_id,pick_up_date,price,created_at) VALUES (1,'2008-01-01 00:00:01',40.0, '2019-03-18 14:30:56');
INSERT INTO olskercupcake.orders (u_id,pick_up_date,price,created_at) VALUES (2,'2008-01-01 10:00:01',55.0, '2019-04-18 14:30:56');
INSERT INTO olskercupcake.orders (u_id,pick_up_date,price,created_at) VALUES (3,'2008-01-01 20:00:01',60.0, '2019-04-18 14:30:56');
INSERT INTO olskercupcake.orders (u_id,pick_up_date,price,created_at) VALUES (4,'2008-01-01 00:35:01',80.0, '2019-04-18 14:30:56');
INSERT INTO olskercupcake.orders (u_id,pick_up_date,price,created_at) VALUES (4,'2008-01-01 00:35:01',80.0, '2019-05-18 14:30:56');

INSERT INTO olskercupcake.orders (u_id,pick_up_date, price,created_at) VALUES (1,'2008-01-01 00:00:01','3.14', '2020-03-18 12:30:56');
INSERT INTO olskercupcake.orders (u_id,pick_up_date, price,created_at) VALUES (2,'2008-01-01 10:00:01','3.14', '2020-03-18 12:30:56');
INSERT INTO olskercupcake.orders (u_id,pick_up_date, price,created_at) VALUES (3,'2008-01-01 20:00:01','3.14', '2020-03-18 12:30:56');
INSERT INTO olskercupcake.orders (u_id,pick_up_date, price,created_at) VALUES (4,'2008-01-01 00:35:01','3.14', '2020-03-18 12:30:56');
INSERT INTO olskercupcake.orders (u_id,pick_up_date, price,created_at) VALUES (4,'2008-01-01 20:35:11','3.14', '2020-03-18 12:30:56');

INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,1,1,1);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,1,2,1);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,2,2,4);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,3,5,4);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,3,3,1);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,4,2,5);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,4,2,5);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,4,3,2);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (1,5,4,1);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,5,1,3);

INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,6,1,3);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,7,1,3);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,8,1,3);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,9,1,3);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,10,1,3);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,6,1,3);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,7,1,3);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,8,1,3);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,9,1,3);
INSERT INTO olskercupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,10,1,3);