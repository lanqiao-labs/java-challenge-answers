use edusys;
create view teaches_view  as select ID id,course_id courseId,semester ,year from teaches;
delete from teaches_view where year =2018;
