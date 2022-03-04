use edusys;
set global log_bin_trust_function_creators=1;
delimiter //
create function getMax(a int,b int) returns int 
begin
return if(a>b,a,b);
end;
//