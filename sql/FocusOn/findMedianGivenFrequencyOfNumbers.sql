-- https://leetcode.cn/problems/find-median-given-frequency-of-numbers
drop table if EXISTS Numbers;
CREATE TABLE If Not Exists Numbers (Number INT, Frequency INT);

insert into Numbers values (0,7);
insert into Numbers values (1,1);
insert into Numbers values (2,3);
insert into Numbers values (3,1);
select * from Numbers;

-- 查询来查找所有数字的中位数
select
    avg(cast(number as float)) median
from
    (
        select
            Number,
            Frequency,
            sum(Frequency) over(order by Number) - Frequency prev_sum,
            sum(Frequency) over(order by Number) curr_sum
        from Numbers
    ) t1,
    (
        select
            sum(Frequency) total_sum
        from Numbers
    ) t2
where
        t1.prev_sum <= (cast(t2.total_sum as float) / 2) and
        t1.curr_sum >= (cast(t2.total_sum as float) / 2)

-- 只要理解prev_sum和curr_sum是频数即可



SELECT
    AVG(Number)median
FROM
    (SELECT n1.Number FROM Numbers n1 JOIN Numbers n2 ON n1.Number>=n2.Number
     GROUP BY
         n1.Number
     HAVING
             SUM(n2.Frequency)>=(SELECT SUM(Frequency) FROM Numbers)/2
        AND
                 SUM(n2.Frequency)-AVG(n1.Frequency)<=(SELECT SUM(Frequency) FROM Numbers)/2
    )s