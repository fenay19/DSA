# Write your MySQL query statement below
select Round(count(distinct a.player_id)/
(select count(distinct player_id) from activity)
,2

) as fraction

from activity a join (
select player_id,min(event_date) as first_login
from activity group by player_id

) f

on a.player_id=f.player_id
and a.event_date=DATE_ADD(f.first_login,Interval 1 day);