use personnel;

-- 约束综合挑战
ALTER TABLE salgrade ADD PRIMARY key LH_PK( `grade`,`losal`,`hisal`);
ALTER TABLE emp ADD  foreign key fk_dept_id(deptno) references dept(deptno);
ALTER TABLE emp ADD  add unique  UQ_NAME(ename);
ALTER TABLE emp ALTER COLUMN comm SET DEFAULT 100;
ALTER TABLE emp add check(hiredate  < '2022-2-28');





