use world;
select  co.Name Name,col.Language Language,IsOfficial from country as co  join  countrylanguage as col  on   col.countrycode = co.code where IsOfficial='T' ;