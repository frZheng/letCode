-- https://leetcode.cn/problems/count-the-number-of-experiments
drop table if EXISTS Experiments;
Create table If Not Exists Experiments (experiment_id int, platform enum('Android','IOS','Web'), experiment_name enum('Programming','Sports','Reading'));
insert into Experiments values (4,'IOS','Programming');
insert into Experiments values (13,'IOS','Sports');
insert into Experiments values (14,'Android','Reading');
insert into Experiments values (8,'Web','Reading');
insert into Experiments values (12,'Web','Reading');
insert into Experiments values (18,'Web','Programming');
select * from Experiments;

-- 三个实验平台中每种实验完成的次数
-- select experiment_id, experiment_name,count(*)  num_experiments from Experiments group by platform,experiment_name;

with pe as
(   select * from
    (
    select 'IOS' platform union all
    select 'Android' platform union all
    select 'Web' platform
    )p
cross join
(
    select 'Programming' experiment_name union all
    select 'Sports' experiment_name union all
    select 'Reading' experiment_name
)e
)
-- select * from pe;
select pe.platform,pe.experiment_name,count(w.platform) as num_experiments
from pe left join Experiments as w using(platform,experiment_name)
group by platform,experiment_name;