create database if not exists  companySys  charset utf8mb4;
use companySys;
create table if not exists company 
(
	company_name varchar(50)  NOT NULL ,
	city varchar(10) ,
	PRIMARY KEY  (company_name)
);
create table if not exists work
(
	per_name       varchar(10) NOT NULL ,
	company_name   varchar(50) , 
	salary        decimal(10,2) ,
	PRIMARY KEY  (`per_name`),
	CONSTRAINT `ce` FOREIGN KEY (`company_name`) REFERENCES `company` (`company_name`)
);
create table if not exists  employ
(
	Id int(11) NOT NULL ,
	person_name  varchar(10) ,
	street       varchar(100) ,
	city         varchar(10) ,
	PRIMARY KEY  (Id),
	CONSTRAINT `ew` FOREIGN KEY (`person_name`) REFERENCES `work` (`per_name`)
);

insert into company(company_name, city) values ("实验楼","成都"),("腾讯","深圳"),("阿里巴巴","杭州");
insert into work(per_name,company_name, salary) values ("张强","阿里巴巴",23245.36),("李明","实验楼",4321.12),("王力","腾讯",22345.67);
insert into employ(Id, person_name,street,city) values(1,"李明","湖北省武汉市武昌区和平大道","武汉"),(2,"王力","天津和平区开封道","天津"),(3,"张强","杭州市西湖区余杭塘路","杭州");