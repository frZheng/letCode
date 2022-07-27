-- https://leetcode.cn/problems/biggest-window-between-visits
drop table if EXISTS UserVisits;
Create table If Not Exists UserVisits (user_id int, visit_date date);

insert into UserVisits values (1,'2020-11-28');
insert into UserVisits values (1,'2020-10-20');
insert into UserVisits values (1,'2020-12-3');
insert into UserVisits values (2,'2020-10-5');
insert into UserVisits values (2,'2020-12-9');
insert into UserVisits values (3,'2020-11-11');
select * from UserVisits;

select user_id,datediff(max(visit_date),min(visit_date)) biggest_window from UserVisits group by user_id;


select
    user_id,max(days) biggest_window
from
    (
        select
            -- 这里是从visit_date里取1.[2020-10-5,2020-12-9] ->2.[2020-10-5,2020-12-9,2021-01-01]
            -- datediff 的1个2进行计算1的2020-10-5 和 2020-12-9, 2020-12-9和2021-01-01
            user_id, datediff(lead(visit_date,1,'2021-01-01')
                over(partition by user_id order by visit_date),visit_date ) days
        from
            UserVisits
    ) s1
group by
    user_id
order by user_id

