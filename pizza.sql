drop database if exists pizza;
create database pizza;
use pizza;

drop table if exists customer;
drop table if exists orders;
drop table if exists location;
drop table if exists delivery_driver;

create table delivery_driver(
	driver_id int not null auto_increment,
	full_name varchar(50) not null,
	primary key(driver_id)
);

create table location(
	location_id int not null auto_increment,
	address varchar(255),
	primary key(location_id)
);

create table customer (
	customer_id int not null auto_increment,
	first_name varchar(20) not null,
	last_name varchar(20) not null,
	phone_number varchar(11) not null,
	location_id int ,
	primary key (customer_id),
    foreign key (location_id) references location(location_id)
);

create table orders (
	order_id int not null auto_increment,
	customer_id int not null,
	driver_id int,
	size varchar(20) not null,
	pizza_name varchar(255) not null,
	price decimal(5, 2) not null,
	primary key (order_id),
	foreign key (customer_id) references customer(customer_id),
    foreign key (driver_id) references delivery_driver(driver_id)
);

use pizza;

insert into delivery_driver(driver_id, full_name) values (1, 'Squidward'), (2, 'Krabs');


 insert into location(location_id, address) values (1, '9301 Wilshire Blvd., Suite 504, Beverly Hills, CA 90210-6149'), (2, '1600 Amphitheatre Parkway Mountain View, CA 94043');



insert into customer(first_name, last_name, phone_number, location_id) Values ('Sponge', 'Bob', '12082089999', 1), ('Patrick', 'Star', '1208208888', 2);

insert into orders(customer_id, driver_id, size, pizza_name, price ) values (1, 1, 'large', 'Krusty Crab Pizza', 7.99), (2, 2, 'small', 'Pizza Hut Pizza', 8.99);






