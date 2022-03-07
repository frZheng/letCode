CREATE TABLE If Not Exists activity (player_id INT, device_id INT, event_date DATE, games_played INT, PRIMARY KEY (player_id, event_date))
Truncate table  activity
INSERT INTO Activity VALUES(1,2,'2016-03-01',5)
INSERT INTO Activity VALUES(1,2,'2016-05-02',6)
INSERT INTO Activity VALUES(2,3,'2017-06-25',1)
INSERT INTO Activity VALUES(3,1,'2016-03-02',0)
INSERT INTO Activity VALUES(3,4,'2018-07-03',5)