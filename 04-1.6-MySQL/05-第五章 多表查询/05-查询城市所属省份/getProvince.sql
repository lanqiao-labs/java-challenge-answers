use division;
select c.name as '城市',p.name as '省份' from division p,division c where p.id = c.province_id;