use world;
-- 5.7 以上版本不支持此语法
select CountryCode as '国家代号' , Population '人口总数' from city group by CountryCode order by Population desc limit 10;
