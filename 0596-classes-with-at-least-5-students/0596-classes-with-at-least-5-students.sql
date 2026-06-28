# Write your MySQL uery statement elow

SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(class)>=5;