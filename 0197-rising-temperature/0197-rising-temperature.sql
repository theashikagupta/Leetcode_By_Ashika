# Write your MySQL query statement below
SELECT today.id 
FROM Weather as today
INNER JOIN Weather as tomorrow
ON DATE_SUB(today.recordDate,INTERVAL 1 DAY)=tomorrow.recordDate
WHERE today.temperature>tomorrow.temperature;
