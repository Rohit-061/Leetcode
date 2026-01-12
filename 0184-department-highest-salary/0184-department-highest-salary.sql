# Write your MySQL query statement below
select d.name as Department, e.name as Employee, e.salary as salary

from Employee as e
join Department as d
on e.departmentId = d.id
join(
    SELECT departmentId, MAX(salary) AS max_salary
    FROM Employee
    GROUP BY departmentId
)m
ON e.departmentId = m.departmentId
AND e.salary = m.max_salary;