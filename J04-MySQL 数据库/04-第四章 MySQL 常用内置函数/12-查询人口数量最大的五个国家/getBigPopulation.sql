use world;
select CountryCode , sum(population) as SumPopulation from city group by countrycode order by SumPopulation desc   limit 5;