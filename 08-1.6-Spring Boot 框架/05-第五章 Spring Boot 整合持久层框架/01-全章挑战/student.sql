create table students(
student_id int auto_increment primary key,
student_name varchar(20) not null,
student_age int,
student_sex char(1)
);

insert into students(student_name,student_age,student_sex) values ('章一', 18, '1');
insert into students(student_name,student_age,student_sex) values ('章二', 16, '0');
insert into students(student_name,student_age,student_sex) values ('章三', 19, '1');
commit;

select * from students;