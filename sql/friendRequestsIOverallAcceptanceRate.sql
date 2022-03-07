-- web: https://leetcode-cn.com/problems/friend-requests-i-overall-acceptance-rate

drop table if EXISTS FriendRequest;
CREATE TABLE FriendRequest
(
    sender_id  INT,
    send_to_id INT,
    request_date DATE
);
drop table if EXISTS RequestAccepted;
CREATE TABLE RequestAccepted
(
    requester_id  INT,
    accepter_id INT,
    accept_date DATE
);
INSERT INTO FriendRequest VALUES(1, 2, '2016_06-01');
INSERT INTO FriendRequest VALUES(1, 3, '2016_06-01');
INSERT INTO FriendRequest VALUES(1, 4, '2016_06-01');
INSERT INTO FriendRequest VALUES(2, 3, '2016_06-02');
INSERT INTO FriendRequest VALUES(3, 4, '2016-06-09');
INSERT INTO RequestAccepted VALUES(1, 2, '2016_06-03');
INSERT INTO RequestAccepted VALUES(1, 3, '2016-06-08');
INSERT INTO RequestAccepted VALUES(2, 3, '2016-06-08');
INSERT INTO RequestAccepted VALUES(3, 4, '2016-06-09');
INSERT INTO RequestAccepted VALUES(3, 4, '2016-06-10');

-- 写一个查询语句，求出好友申请的通过率，用 2 位小数表示。通过率由接受好友申请的数目除以申请总数。

select round(
    coalesce(count(distinct a.requester_id,a.accepter_id)/
             (select count(distinct b.sender_id,b.send_to_id) from FriendRequest b),0),2) accept_rate
from RequestAccepted a