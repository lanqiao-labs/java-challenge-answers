use mysql;
CREATE USER 'Rong'@'localhost' IDENTIFIED BY '123456';
GRANT select on  performance_schema.* TO 'Rong'@'localhost' ;