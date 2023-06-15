# Write your MySQL query statement below
WITH total as (
    SELECT person_name,
           SUM(Weight) OVER (ORDER BY turn) as running_total 
    FROM Queue
    ORDER BY turn)

SELECT person_name
FROM total
WHERE running_total <= 1000
ORDER BY running_total DESC
LIMIT 1;