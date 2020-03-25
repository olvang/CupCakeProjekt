set foreign_key_checks=0;
TRUNCATE TABLE users;
TRUNCATE TABLE cupcake_bottom;
TRUNCATE TABLE cupcake_top;
TRUNCATE TABLE orders;
TRUNCATE TABLE order_line;
set foreign_key_checks=1;
INSERT INTO `OlskerCupcake`.`users` (`email`,`password`,`balance`) VALUES ('someone@nowhere.com','a1234',100);
INSERT INTO `OlskerCupcake`.`users` (`email`,`password`,`balance`) VALUES ('jensen@nowhere.com','b1234',0);
INSERT INTO `OlskerCupcake`.`users` (`email`,`password`,`balance`) VALUES ('pedersen@nowhere.com','c1234',40);
INSERT INTO `OlskerCupcake`.`users` (`email`,`password`,`balance`) VALUES ('hansen@nowhere.com','d1234',4000);
INSERT INTO `OlskerCupcake`.`users` (`email`,`password`,`balance`,`admin`) VALUES ('admin@admin.com','admin',100,1);


INSERT INTO `OlskerCupcake`.`cupcake_bottom` (`cb_price`,`cb_name`) VALUES (5.00,'Chocolate');
INSERT INTO `OlskerCupcake`.`cupcake_bottom` (`cb_price`,`cb_name`) VALUES (5.00,'Vanilla');
INSERT INTO `OlskerCupcake`.`cupcake_bottom` (`cb_price`,`cb_name`) VALUES (5.00,'Nutmeg');
INSERT INTO `OlskerCupcake`.`cupcake_bottom` (`cb_price`,`cb_name`) VALUES (6.00,'Pistacio');
INSERT INTO `OlskerCupcake`.`cupcake_bottom` (`cb_price`,`cb_name`) VALUES (7.00,'Almond');


INSERT INTO `OlskerCupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (5.00,'Chocolate');
INSERT INTO `OlskerCupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (5.00,'Blueberry');
INSERT INTO `OlskerCupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (5.00,'Rasberry');
INSERT INTO `OlskerCupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (6.00,'Crispy');
INSERT INTO `OlskerCupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (6.00,'Strawberry');
INSERT INTO `OlskerCupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (7.00,'Rum/Raisin');
INSERT INTO `OlskerCupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (8.00,'Orange');
INSERT INTO `OlskerCupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (8.00,'Lemon');
INSERT INTO `OlskerCupcake`.`cupcake_top` (`cp_price`,`cp_name`) VALUES (9.00,'Blue cheese');

INSERT INTO OlskerCupcake.orders (u_id,pick_up_date,price,created_at) VALUES (1,'2008-01-01 00:00:01',40.0, '2020-03-18 12:30:56');
INSERT INTO OlskerCupcake.orders (u_id,pick_up_date,price,created_at) VALUES (1,'2008-01-01 00:00:01',22.0, '2020-03-18 12:30:56');
INSERT INTO OlskerCupcake.orders (u_id,pick_up_date,price,created_at) VALUES (2,'2008-01-01 10:00:01',46.0, '2020-05-18 11:30:56');
INSERT INTO OlskerCupcake.orders (u_id,pick_up_date,price,created_at) VALUES (3,'2008-01-01 20:00:01',64.0, '2020-05-18 10:30:56');
INSERT INTO OlskerCupcake.orders (u_id,pick_up_date,price,created_at) VALUES (4,'2008-01-01 00:35:01',41.0, '2020-04-18 09:30:56');
INSERT INTO OlskerCupcake.orders (u_id,pick_up_date,price,created_at) VALUES (4,'2008-01-01 00:35:01',60.0, '2020-04-18 08:30:56');
INSERT INTO OlskerCupcake.orders (u_id,pick_up_date,price,created_at) VALUES (1,'2008-01-01 00:00:01',40.0, '2019-03-18 14:30:56');
INSERT INTO OlskerCupcake.orders (u_id,pick_up_date,price,created_at) VALUES (1,'2008-01-01 00:00:01',60.0, '2019-03-18 14:30:56');
INSERT INTO OlskerCupcake.orders (u_id,pick_up_date,price,created_at) VALUES (2,'2008-01-01 10:00:01',60.0, '2019-04-18 14:30:56');
INSERT INTO OlskerCupcake.orders (u_id,pick_up_date,price,created_at) VALUES (3,'2008-01-01 20:00:01',60.0, '2019-04-18 14:30:56');
INSERT INTO OlskerCupcake.orders (u_id,pick_up_date,price,created_at) VALUES (4,'2008-01-01 00:35:01',99.0, '2019-04-18 14:30:56');
INSERT INTO OlskerCupcake.orders (u_id,pick_up_date,price,created_at) VALUES (4,'2008-01-01 00:35:01',99.0, '2019-05-18 14:30:56');

INSERT INTO OlskerCupcake.orders (u_id,pick_up_date, price,created_at) VALUES (1,'2008-01-01 00:00:01','99.0', '2020-03-18 12:30:56');
INSERT INTO OlskerCupcake.orders (u_id,pick_up_date, price,created_at) VALUES (2,'2008-01-01 10:00:01','99.0', '2020-03-18 12:30:56');
INSERT INTO OlskerCupcake.orders (u_id,pick_up_date, price,created_at) VALUES (3,'2008-01-01 20:00:01','99.0', '2020-03-18 12:30:56');
INSERT INTO OlskerCupcake.orders (u_id,pick_up_date, price,created_at) VALUES (4,'2008-01-01 00:35:01','99.0', '2020-03-18 12:30:56');
INSERT INTO OlskerCupcake.orders (u_id,pick_up_date, price,created_at) VALUES (4,'2008-01-01 20:35:11','99.0', '2020-03-18 12:30:56');

INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,1,1,1);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,1,2,1);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,2,2,4);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,3,5,4);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,3,3,1);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,4,2,5);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,4,2,5);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (2,4,3,2);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (1,5,4,1);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,5,1,3);

INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,6,1,3);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,7,1,3);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,8,1,3);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,9,1,3);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,10,1,3);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,6,1,3);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,7,1,3);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,8,1,3);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,9,1,3);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (3,10,1,3);

INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (9,11,2,4);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (9,12,2,4);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (9,13,2,4);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (9,14,2,4);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (9,15,2,4);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (9,16,2,4);
INSERT INTO OlskerCupcake.order_line (amount,o_id,cb_id,cp_id) VALUES (9,17,2,4);