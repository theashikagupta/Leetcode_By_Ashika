-- # Write your MySQL query statement below

-- SELECT Name AS person_name
-- FROM (
--      SELECT turn 
-- AS Turn,
-- person_id AS ID,
-- person_name AS Name,
-- weight AS Weight,
-- SUM(weight) OVER (ORDER BY turn) AS Total_Weight
-- FROM Queue

-- ) AS temp
-- WHERE (Total_Weight>=1000)
-- ORDER BY turn
-- LIMIT 1;



WITH temp AS (
    SELECT turn 
AS Turn,
person_id AS ID,
person_name AS Name,
weight AS Weight,
SUM(weight) OVER (ORDER BY turn) AS Total_Weight
FROM Queue
)

SELECT NAME AS person_name
FROM temp
WHERE Total_Weight<=1000
ORDER BY turn DESC
LIMIT 1;