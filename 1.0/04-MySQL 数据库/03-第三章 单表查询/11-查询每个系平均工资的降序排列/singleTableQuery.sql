use world;
-- 5.7以上版本 group by 语法支持
set @@GLOBAL.sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
select dept_name,avg(salary) avg_salary from instructor group by dept_name order by avg_salary desc;   
