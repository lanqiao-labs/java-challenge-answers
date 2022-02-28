use world;
select ci.Name CityName,co.Name CountryName from city as ci,country as co where ci.CountryCode=co.code limit 10;