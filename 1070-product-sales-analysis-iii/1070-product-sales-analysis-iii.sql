# Write your MySQL query statement below
WITH first_year_sales AS (
    SELECT 
        s.product_id,
        MIN(s.year) AS first_year
    FROM 
        Sales s
    INNER JOIN 
        Product p ON p.product_id = s.product_id
    GROUP BY 
        s.product_id
)

SELECT 
    f.product_id,
    f.first_year,
    s.quantity,
    s.price
FROM 
    first_year_sales f
JOIN 
    Sales s ON f.product_id = s.product_id AND f.first_year = s.year;
    
#     SELECT
#     Sub2.product_id,
#     Sub2.year first_year,
#     Sub2.quantity,
#     Sub2.price
# FROM
#     (
#         SELECT
#             T1.*
#         FROM
#             Sales T1
#         INNER JOIN
#             (
#                 SELECT
#                     product_id,
#                     MIN(year) as MYEAR
#                 FROM
#                     Sales
#                 GROUP BY
#                     product_id
#
#             )Sub ON T1.product_id = Sub.product_id
#             AND T1.year = Sub.MYEAR
#     )Sub2 
