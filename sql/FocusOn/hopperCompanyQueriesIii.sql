-- https://leetcode.cn/problems/hopper-company-queries-iii/
-- 运行环境 mysql8
drop table if EXISTS Drivers;
Create table If Not Exists Drivers (driver_id int, join_date date);
drop table if EXISTS Rides;
Create table If Not Exists Rides (ride_id int, user_id int, requested_at date);
drop table if EXISTS AcceptedRides;
Create table If Not Exists AcceptedRides (ride_id int, driver_id int, ride_distance int, ride_duration int);

insert into Drivers values (10,'2019-12-10');
insert into Drivers values (8,'2020-1-13');
insert into Drivers values (5,'2020-2-16');
insert into Drivers values (7,'2020-3-8');
insert into Drivers values (4,'2020-5-17');
insert into Drivers values (1,'2020-10-24');
insert into Drivers values (6,'2021-1-5');

insert into Rides values (6,75,'2019-12-9');
insert into Rides values (1,54,'2020-2-9');
insert into Rides values (10,63,'2020-3-4');
insert into Rides values (19,39,'2020-4-6');
insert into Rides values (3,41,'2020-6-3');
insert into Rides values (13,52,'2020-6-22');
insert into Rides values (7,69,'2020-7-16');
insert into Rides values (17,70,'2020-8-25');
insert into Rides values (20,81,'2020-11-2');
insert into Rides values (5,57,'2020-11-9');
insert into Rides values (2,42,'2020-12-9');
insert into Rides values (11,68,'2021-1-11');
insert into Rides values (15,32,'2021-1-17');
insert into Rides values (12,11,'2021-1-19');
insert into Rides values (14,18,'2021-1-27');

insert into AcceptedRides values (10,10,63,38);
insert into AcceptedRides values (13,10,73,96);
insert into AcceptedRides values (7,8,100,28);
insert into AcceptedRides values (17,7,119,68);
insert into AcceptedRides values (20,1,121,92);
insert into AcceptedRides values (5,7,42,101);
insert into AcceptedRides values (2,4,6,38);
insert into AcceptedRides values (11,8,37,43);
insert into AcceptedRides values (15,8,108,82);
insert into AcceptedRides values (12,8,38,34);
insert into AcceptedRides values (14,1,90,74);

select * from Drivers;
select * from Rides;
select * from AcceptedRides;

-- select * from AcceptedRides a left join Rides r on a.ride_id=r.ride_id left join Drivers d on a.driver_id=d.driver_id;

with recursive t3 as (select '2020-01-01' n
                      union all select date_add(n,interval 1 month) -- 得到 (2020年的 1到12月 但是 会多一个 2021年1yue 不要紧后面会滤掉)
                      from t3 where year(n) =2020),

    t1 as (
select
    sum(ride_distance) ride_distance,sum(ride_duration) ride_duration,month(requested_at) `month` -- 得到应有的每月骑行距离和骑行持续时间
from
    (
    select
    a.ride_distance,a.ride_duration,r.requested_at
    from
    AcceptedRides a left join Rides  r
    using(ride_id)
    )s1
where date_format(requested_at,'%Y') = '2020'
group by date_format(requested_at,'%Y-%m')

    );
-- select * from t3;
-- select * from t1;
select
    month,average_ride_distance,average_ride_duration
from
    (
    select
    month ,round(sum(ride_distance) over(order by month rows between current row and 2 following ) /3,2) average_ride_distance,round(sum(ride_duration) over(order by month rows between current row and 2 following ) /3,2) average_ride_duration
    from

    (
    select ride_distance,ride_duration,month `month` -- 上下拼接 取到完整的12个月
    from
    t1

    union all

    select
    0 ride_distance,0 ride_duration, month(n) `month` -- 没有的月份骑行距离和骑行持续时间置零
    from
    t3
    where month(n) not in (select month from t1 ) and year(n) = 2020
    ) s1
    )ss1
where month not in(11,12) -- 最后筛选掉 11 12月的内容