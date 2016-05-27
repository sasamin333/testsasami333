drop database if exists datalist;
create database datalist;
use datalist;

create table user(
	user_id int not null primary key auto_increment,
	user_name varchar(32) not null,
	password varchar(255) not null,
		oauth_id varchar(50),
	oauth_name varchar(50)
	);



	insert into user(user_id,user_name,password)values
	(1,"taro",123),
	(2,"hana",456),
	(3,"take",789);