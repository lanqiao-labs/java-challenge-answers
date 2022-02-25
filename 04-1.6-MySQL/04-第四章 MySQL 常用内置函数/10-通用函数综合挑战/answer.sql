use personnel;

-- 通用函数综合挑战
select sha(ename) "姓名",FORMAT((ifNull(comm,0)+sal) *12 ,3)  "年收入", current_user() "当前用户"  from emp;

