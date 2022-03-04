use vip;
select u.name '用户' ,l.name '等级' from user u,level l where u.score >l.low and u.score<l.high;
