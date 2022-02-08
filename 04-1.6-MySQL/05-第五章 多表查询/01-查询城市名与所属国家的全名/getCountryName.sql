use world;
select city.Name CityName,country.Name CountryName from city,country where city.CountryCode=country.code limit 10;