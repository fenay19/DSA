# Write your MySQL query statement below
select Department,Employee,Salary
from (select d.name as Department,e.name as Employee,e.salary as Salary,
Dense_rank() Over( partition by e.departmentId 
order by e.salary desc) as rnk
from employee e join department d
on e.departmentId=d.id) x
where rnk<=3;