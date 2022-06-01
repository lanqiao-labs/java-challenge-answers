use world;
select CountryCode '国家代号' , sum(Population)  '人口总数' from city group by CountryCode order by  sum(Population) desc limit 10;


