CREATE DATABASE IF NOT EXISTS demo DEFAULT CHARSET utf8;
use demo;
CREATE TABLE IF NOT EXISTS work
(
	ID INT(10)  NOT NULL ,
	Name VARCHAR(20) NOT NULL,
	Age INT(3),
	Salary INT(7),
	PRIMARY KEY (`ID`)
);
insert into work values(1,'zhangsan',30,11000),(2,'Rong',29,11000);
