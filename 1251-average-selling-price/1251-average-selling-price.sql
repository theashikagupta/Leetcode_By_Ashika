# Write your MySQL query statement below
SELECT a.product_id , 
ROUND(IFNULL(SUM(a.price*b.units)/SUM(b.units),0),2)
 AS average_price
FROM Prices a
LEFT JOIN UnitsSold b
ON a.product_id=b.product_id
AND b.purchase_date BETWEEN a.start_date AND a.end_date
GROUP BY b.product_id;