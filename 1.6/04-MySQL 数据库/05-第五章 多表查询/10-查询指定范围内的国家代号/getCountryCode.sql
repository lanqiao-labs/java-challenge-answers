use world;
select CountryCode  ,Language from countrylanguage where Language in( select language from countrylanguage where countrycode = 'FRO');