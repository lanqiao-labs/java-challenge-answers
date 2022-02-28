use personnel;

-- DML 综合挑战
insert into emp values(9878,"张三","CLERK",7499,"2022-1-5",1800,0,10),(8868,"李四","CLERK",7566, "2022-2-12",2500, null,20);
update emp set mgr = (select mgr from (select mgr from emp where ename ='BLAKE') as m  ) where ename='scott';
update emp set comm=0 where comm is null;
delete from emp where empno =  (select empno from (select max(empno) as empno from emp) as m);
delete from emp where empno in (select * from  (select empno from emp where mgr = (select empno from emp where ename='BLAKE')) as m);



