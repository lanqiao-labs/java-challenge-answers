use edusys;
select dept_name ,max(salary) as  max_salary,min(salary) as  min_salary from instructor group by dept_name;