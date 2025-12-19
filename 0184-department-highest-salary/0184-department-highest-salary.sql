# Write your MySQL query statement below
select 
    d.name as 'Department' ,
    e1.name as 'Employee' ,
    e1.salary  as  'Salary'    
from
    employee e1
inner join 
    department d
on 
    d.id=e1.departmentId
where 
    e1.salary=(
        select
            max(salary)
        from 
            employee e2
        where 
            e2.departmentId=e1.departmentId
)