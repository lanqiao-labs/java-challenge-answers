use edusys;
create view comp_spring_2018 as select s.course_id,building,room_number  from course c ,section s where c.course_id = s.course_id and c.dept_name='Comp. Sci.' and s.year=2018;
create view comp_spring_2018_taylor as select course_id,room_number  from comp_spring_2018 where  building='Taylor';