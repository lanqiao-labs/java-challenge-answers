use personnel;


-- 多行函数综合挑战
select deptno '部门编号', max(sal) '最高工资', min(sal) '最低工资',avg(sal) '平均工资' from emp group by deptno having avg(sal)>= 2000 order by deptno desc;



