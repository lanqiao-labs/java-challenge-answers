-- 创建数据库
CREATE DATABASE `testddl` DEFAULT CHARACTER SET utf8mb4;

-- 创建表
use testddl;
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `eid` int NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `sal` decimal DEFAULT NULL,
  `deptno` int DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `did` int NOT NULL,
  `dname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 主键为自增，从 `10` 开始,修改类型 
alter table emp AUTO_INCREMENT=10;
alter table dept AUTO_INCREMENT=10;
alter table emp modify column sal int;


-- 删除emp表和dept表的数据
delete from emp;
truncate table dept;
-- 删除表和数据库
drop table emp;
drop database testddl;
