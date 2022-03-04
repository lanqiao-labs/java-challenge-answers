use personnel;


-- 基础函数综合挑战
select REVERSE(ename) '名字', ROUND(sal / 30,2) '日薪',datediff('2022-1-1',hiredate) '入职天数' from emp;

