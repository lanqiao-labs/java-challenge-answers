create database product CHARSET UTF8;
use product;
create table product_info (
  id int not null,
  name varchar(10),
  price decimal(8,2),
  intro varchar(256)
)