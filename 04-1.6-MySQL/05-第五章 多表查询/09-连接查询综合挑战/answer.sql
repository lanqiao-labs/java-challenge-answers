use personnel;

-- 连接查询综合挑战
select ename '名字',hiredate  '入职时间',dname  '部门名称' from emp , dept where emp.deptno = dept.deptno;
select ename  '名字',sal  '工资', (case(grade) when "1" then "A"  when "2" then "B"  when "3" then "C"  when "4" then "D"  else "E" end ) as '级别' from emp , salgrade where emp.sal > salgrade.losal and emp.sal<salgrade.hisal;
select b.* from emp a,emp b where b.empno=a.mgr and a.ename='SMITH';
select * from emp right join dept on emp.deptno=dept.deptno;
