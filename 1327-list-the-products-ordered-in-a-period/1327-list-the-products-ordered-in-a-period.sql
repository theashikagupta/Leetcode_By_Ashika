# Write your MySQL query statement below

SELECT p.product_name  , SUM(o.unit) as unit
FROM Products p
JOIN Orders o
ON p.product_id = o.product_id
WHERE MONTH(order_date)='02' AND YEAR(order_date)='2020' 
GROUP BY p.product_name
HAVING unit>=100;