use edusys;
select  s.ID,s.name,t.course_id,t.grade  from student s ,takes t,course c  where c.dept_name='biology' and c.course_id =t.course_id and s.id = t.id  ;
