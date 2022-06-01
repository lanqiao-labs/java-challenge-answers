use personnel;

-- 子查询综合挑战
select ename '名字' from emp where sal = (select max(sal) from emp);
select dname '部门',(select COUNT(DEPTNO) from emp where DEPTNO = 10) / (select COUNT(*) from emp) as '比例' FROM dept  where DEPTNO = 10;
select * from emp where DEPTNO = (select DEPTNO from dept where LOC = 'NEW YORK');
select * from emp e1 where sal > ( select avg(sal) from emp e2 where e1.deptno = deptno );

