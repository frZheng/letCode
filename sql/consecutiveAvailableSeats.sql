-- web: https://leetcode-cn.com/problems/consecutive-available-seats
drop table if EXISTS cinema;
Create table If Not Exists cinema (seat_id int, free int);
Truncate table cinema;
insert into cinema (seat_id, free) values (1, 1);
insert into cinema (seat_id, free) values (2, 0);
insert into cinema (seat_id, free) values (3, 1);
insert into cinema (seat_id, free) values (4, 1);
insert into cinema (seat_id, free) values (5, 1);

-- 获取所有空余座位，并将它们按照 seat_id 排序后返回
-- 找到连续的
select * from
    (select a.seat_id
     from cinema a,cinema b
     where a.seat_id = b.seat_id - 1
       and a.free = 1
       and b.free = 1
     union
     select a.seat_id
     from cinema a,cinema b
     where a.seat_id = b.seat_id + 1
       and a.free = 1
       and b.free = 1) c
order by seat_id

