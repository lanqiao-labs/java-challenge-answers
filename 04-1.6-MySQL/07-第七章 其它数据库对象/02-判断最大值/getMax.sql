use edusys;
delimiter //
create function getMax(a INTEGER,b INTEGER) returns INTEGER 
begin
RETURN if(a>b,a,b); 
end;
//