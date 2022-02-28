use world;
select Name,GNP ,Population from country where gnp > (select gnp from country where name='France');