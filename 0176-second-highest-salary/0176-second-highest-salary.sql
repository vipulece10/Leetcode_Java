# Write your MySQL query statement below

select MAX(salary) AS SecondHighestSalary
from Employee 
where salary < (Select MAX(salary) from Employee);
