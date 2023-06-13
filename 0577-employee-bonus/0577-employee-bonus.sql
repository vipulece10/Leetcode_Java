# Write your MySQL query statement below
Select e.name,
b.bonus
from Employee as  e
LEFT JOIN Bonus as b
on e.empID = b.empID
where b.bonus < 1000 or b.bonus is null;