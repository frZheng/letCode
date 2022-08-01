-- web: https://leetcode-cn.com/problems/game-play-analysis-ii
drop table if EXISTS activity;
CREATE TABLE If Not Exists activity (player_id INT, device_id INT, event_date DATE, games_played INT, PRIMARY KEY (player_id, event_date));
Truncate table  activity;
INSERT INTO Activity VALUES(1,2,'2016-03-01',5);
INSERT INTO Activity VALUES(1,2,'2016-05-02',6);
INSERT INTO Activity VALUES(2,3,'2017-06-25',1);
INSERT INTO Activity VALUES(3,1,'2016-03-02',0);
INSERT INTO Activity VALUES(3,4,'2018-07-03',5);

-- 每组玩家和日期，以及玩家到目前为止玩了多少游戏

select
    a1.player_id,
    a1.event_date,
    sum(a2.games_played) games_played_so_far
from Activity a1,Activity a2
where a1.player_id=a2.player_id and  -- 这里就是笛卡尔积了
    a1.event_date>=a2.event_date  -- 看似只是一个简单的日期比较缺筛选出了1，2，3然后进行sum即可
group by 1,2; -- 个人觉得group by 日期，但是其它的就取不出来了，所以1，2有啥用