-- web: https://leetcode-cn.com/problems/rising-temperature
Create table If Not Exists Weather (id int, recordDate date, temperature int);
Truncate table Weather;
insert into Weather (id, recordDate, temperature) values ('1', '2015-01-01', '10');
insert into Weather (id, recordDate, temperature) values ('2', '2015-01-02', '25');
insert into Weather (id, recordDate, temperature) values ('3', '2015-01-03', '20');
insert into Weather (id, recordDate, temperature) values ('4', '2015-01-04', '30');

-- 查找与之前（昨天的）日期相比温度更高的所有日期的 id


select b.id from Weather a,Weather b
where TIMESTAMPDIFF(day, a.recordDate, b.recordDate) = 1
  and a.Temperature < b.Temperature