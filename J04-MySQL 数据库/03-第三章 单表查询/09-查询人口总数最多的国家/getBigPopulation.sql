use world;
select CountryCode as '国家代号' , Population '人口总数' from city group by CountryCode order by Population desc limit 10;
