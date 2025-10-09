# Write your MySQL query statement below

SELECT d.name as Department , e.name as Employee ,e.salary as Salary
FROM Employee e
INNER JOIN Department d
ON e.departmentId=d.id
WHERE 3 > (
    SELECT COUNT(DISTINCT (e2.salary) )
    FROM Employee e2
    WHERE e2.salary>e.salary 
    AND e2.departmentId=e.departmentId
)

