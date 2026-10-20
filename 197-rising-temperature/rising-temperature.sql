# Write your MySQL query statement below
select w.id as id from 
weather w join weather a
on w.recordDate =DATE_ADD(a.recordDate , Interval 1 day) and 
w. temperature >a. temperature;