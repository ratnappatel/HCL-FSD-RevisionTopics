create database revision;
create table user_details
(
	id int,
	name varchar(50),
	email varchar(50),
	password varchar(20),
	type varchar(1)
);
insert into user_details values(1,"Ratna","ratnabpatel@gmail.com","Ratna@123","A");
insert into user_details values(2,"Ketan","ketan.neel@gmail.com","Ketan@123","U");


select * from user_details;



CREATE TABLE `products` (
  `productid` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(30) DEFAULT NULL,
  `category` varchar(20) DEFAULT NULL,
  `Quantity` int DEFAULT NULL,
  `price` decimal(6,2) DEFAULT NULL,
  `buyingPrice` decimal(6,2) DEFAULT NULL,
  PRIMARY KEY (`productid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
