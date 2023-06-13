# Write your MySQL query statement below
Select p.product_name,
s.year,
(s.price) AS price
from Sales as s
LEFT JOIN Product as p
on s.product_id = p.product_id;