use personnel;

-- GROUP 综合挑战
select * from emp order by deptno ,sal desc;
select deptno,count(*) from emp group by deptno having count(*)>4;
select empno,ename,deptno,job ,sal from emp  where deptno =10 order by sal desc limit 1;
