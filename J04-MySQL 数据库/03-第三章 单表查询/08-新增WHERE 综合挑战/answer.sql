use personnel;
-- WHERE 综合挑战
select job,hiredate from emp where ename ='SMITH';
select * from emp where deptno <> 20;
select * from emp where sal >2000;
select * from emp where job='SALESMAN' limit 3;
