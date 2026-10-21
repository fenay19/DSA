# Write your MySQL query statement below
with wtmax as (
select person_name,weight,turn,
sum(weight) over(order by turn) as total_wt
from queue

)

select person_name from wtmax
where total_wt<=1000
order by turn desc
limit 1;