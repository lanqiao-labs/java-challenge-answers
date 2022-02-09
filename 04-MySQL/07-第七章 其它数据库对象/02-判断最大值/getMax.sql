use edusys;
delimiter //
create function getMax(a int,b int) returns int 
begin
return if(a>b,a,b);
end;
//