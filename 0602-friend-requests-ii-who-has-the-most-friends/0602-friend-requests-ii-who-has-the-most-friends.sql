# Write your MySQL query statement below

SELECT id , COUNT(*) as num
FROM (
    SELECT requester_id as id
    FROM RequestAccepted
    UNION ALL 
    SELECT accepter_id as id
    FROM RequestAccepted
) AS id
GROUP BY id
ORDER BY num DESC
LIMIT 1;
