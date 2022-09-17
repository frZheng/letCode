DROP TABLE IF EXISTS tb_user_log;
CREATE TABLE tb_user_log (
                             id INT PRIMARY KEY AUTO_INCREMENT COMMENT '自增ID',
                             uid INT NOT NULL COMMENT '用户ID',
                             artical_id INT NOT NULL COMMENT '视频ID',
                             in_time datetime COMMENT '进入时间',
                             out_time datetime COMMENT '离开时间',
                             sign_in TINYINT DEFAULT 0 COMMENT '是否签到'
) CHARACTER SET utf8 COLLATE utf8_bin;

INSERT INTO tb_user_log(uid, artical_id, in_time, out_time, sign_in) VALUES
(101, 0, '2021-11-01 10:00:00', '2021-11-01 10:00:42', 1),
(102, 9001, '2021-11-01 10:00:00', '2021-11-01 10:00:09', 0),
(103, 9001, '2021-11-01 10:00:01', '2021-11-01 10:01:50', 0),
(101, 9002, '2021-11-02 10:00:09', '2021-11-02 10:00:28', 0),
(103, 9002, '2021-11-02 10:00:51', '2021-11-02 10:00:59', 0),
(104, 9001, '2021-11-02 10:00:28', '2021-11-02 10:00:50', 0),
(101, 9003, '2021-11-03 11:00:55', '2021-11-03 11:01:24', 0),
(104, 9003, '2021-11-03 11:00:45', '2021-11-03 11:00:55', 0),
(105, 9003, '2021-11-03 11:00:53', '2021-11-03 11:00:59', 0),
(101, 9002, '2021-11-04 11:00:55', '2021-11-04 11:00:59', 0);

select
a.dt,round(count(b.uid)/count(a.uid),2) as uv_left_rate
-- *
from
(select uid,min(date(in_time)) as dt from tb_user_log
group by uid
) as a
left join
(select uid,date(in_time) as dt from tb_user_log
union
select uid,date(out_time) as dt from tb_user_log
    ) as b
on a.uid=b.uid and a.dt=date_sub(b.dt,interval 1 day)
where date_format(a.dt,'%Y-%m')='2021-11'
group by a.dt;

