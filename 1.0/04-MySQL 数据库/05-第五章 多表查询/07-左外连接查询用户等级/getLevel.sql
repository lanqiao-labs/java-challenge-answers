use vip;
select u.name '用户' ,l.name '等级' from user u left join level l on  u.score >l.low and u.score<l.high;