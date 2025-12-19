# Write your MySQL query statement below
WITH OrderCount AS (
    SELECT customer_number, COUNT(*) AS total_orders
    FROM Orders
    GROUP BY customer_number
)
SELECT customer_number
FROM OrderCount
ORDER BY total_orders DESC
LIMIT 1;


-- SELECT customer_number
-- FROM Orders
-- GROUP BY customer_number
-- ORDER BY COUNT(*) DESC
-- LIMIT 1;
