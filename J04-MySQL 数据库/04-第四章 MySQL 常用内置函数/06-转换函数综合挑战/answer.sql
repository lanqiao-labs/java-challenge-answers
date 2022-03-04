use personnel;

-- 转换函数综合挑战
 select DATE_FORMAT(hiredate,'%y-%m') as '入职时间', STR_TO_DATE(cast( hiredate as signed)+14,"%Y%m%d") as '新日期' from emp;
