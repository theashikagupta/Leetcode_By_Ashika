# Write your MySQL query statement be
SELECT DISTINCT activity_date as day,
COUNT(DISTINCT user_id) as active_users
FROM (SELECT user_id , activity_date 
    FROM Activity
    WHERE activity_date BETWEEN '2019-06-28' AND '2019-07-27')  AS sub
    GROUP BY activity_date;