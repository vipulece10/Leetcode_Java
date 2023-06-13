# Write your MySQL query statement below
select u.unique_id , e.name
from Employees AS e 
LEFT JOIN EmployeeUNI as u
on e.id = u.id