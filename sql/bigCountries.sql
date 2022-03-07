-- web: https://leetcode-cn.com/problems/big-countries
drop table if EXISTS World;
Create table If Not Exists World (name varchar(255), continent varchar(255), area int, population int, gdp bigint);
Truncate table World;
insert into World (name, continent, area, population, gdp) values ('Afghanistan', 'Asia', 652230, 25500100, 20343000000);
insert into World (name, continent, area, population, gdp) values ('Albania', 'Europe', 28748, 2831741, 12960000000);
insert into World (name, continent, area, population, gdp) values ('Algeria', 'Africa', 2381741, 37100000, 188681000000);
insert into World (name, continent, area, population, gdp) values ('Andorra', 'Europe', 468, 78115, 3712000000);
insert into World (name, continent, area, population, gdp) values ('Angola', 'Africa', 1246700, 20609294, 100990000000);

-- 如果一个国家的面积超过 300 万平方公里，或者人口超过 2500 万，那么这个国家就是大国家。
-- 编写一个 SQL 查询，输出表中所有大国家的名称、人口和面积。

select name,population,area from World
where area > 3000000 or population > 25000000