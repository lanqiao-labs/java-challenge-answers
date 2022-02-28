create database if not exists  studentSys charset utf8;
use studentSys;
create table if not exists student_info
(
	Id int(11) NOT NULL ,
	name varchar(50) ,
	PRIMARY KEY  (Id)
);
create table if not exists student_score
(
	Id int(11) NOT NULL ,
	score int(11) , 
	Sid int(11) ,
	PRIMARY KEY  (`Id`),
	CONSTRAINT `ss` FOREIGN KEY (`Sid`) REFERENCES `student_info` (`Id`)
)
