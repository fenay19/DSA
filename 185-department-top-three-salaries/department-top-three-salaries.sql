# Write your MySQL query statement below
with maxsal as(
select e.name as emp_name,e.salary,d.name as departement
,dense_rank() over(partition by d.id order by e.salary desc) as rnk
from employee e join department d
on e.departmentId=d.id


)
select departement as Department,emp_name as  Employee ,salary as Salary
from maxsal 
where rnk<=3;