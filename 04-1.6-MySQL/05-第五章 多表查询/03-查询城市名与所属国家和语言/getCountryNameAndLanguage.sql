use world;
select ci.Name CityName,co.Name CountryName,col.Language from city as ci,country as co ,countrylanguage as col  where ci.CountryCode=co.code and col.countrycode = ci.countrycode limit 10;