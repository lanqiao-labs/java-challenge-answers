use vip;
select u.name '用户' ,l.name '等级' from  level l  right join user u on  u.score >l.low and u.score<l.high;