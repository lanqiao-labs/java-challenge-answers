use world;
select CountryCode '国家代号' , sum(Population)  '人口总数' from city group by CountryCode having sum(Population)>100000000 order by  sum(Population)  limit 2;