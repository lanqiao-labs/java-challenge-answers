use edusys;
create view student_view  as select ID id,name,tot_cred cred from student;
update student_view set name ='Phsics' where id ='70557';
