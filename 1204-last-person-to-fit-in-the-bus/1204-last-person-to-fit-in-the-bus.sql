# Write your MySQL query statement below

SELECT person_name
FROM (SELECT 
    turn, 
    person_id, 
    person_name, 
    weight, 
    SUM(weight) OVER (ORDER BY turn) AS TotalWeight
FROM Queue) AS csum
WHERE TotalWeight<=1000
ORDER BY TotalWeight DESC
LIMIT 1;
