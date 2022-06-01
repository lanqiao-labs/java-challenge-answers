use world;
select dept_name,avg(salary) avg_salary from instructor group by dept_name order by avg_salary desc;   
