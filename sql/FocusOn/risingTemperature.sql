-- web: https://leetcode-cn.com/problems/rising-temperature
drop table if EXISTS Weather;
Create table If Not Exists Weather (id int, recordDate date, temperature int);
Truncate table Weather;
insert into Weather (id, recordDate, temperature) values ('1', '2015-01-01', '10');
insert into Weather (id, recordDate, temperature) values ('2', '2015-01-02', '25');
insert into Weather (id, recordDate, temperature) values ('3', '2015-01-03', '20');
insert into Weather (id, recordDate, temperature) values ('4', '2015-01-04', '30');

select * from Weather;
-- 查找与之前（昨天的）日期相比温度更高的所有日期的 id


select b.id from Weather a,Weather b
where TIMESTAMPDIFF(day, a.recordDate, b.recordDate) = 1
  and a.Temperature < b.Temperature

select
    Id
from
    (
        select Id,RecordDate,Temperature,
               lag(RecordDate,1,9999-99-99) over (order by RecordDate) yd, -- 昨天的日期
               lag(Temperature,1,999) over(order by RecordDate ) yt -- 昨天的温度
        from Weather
    )tmp
where Temperature >yt-- 昨天和今天，温度高于昨天
  and datediff(RecordDate,yd)=1