# Write your MySQL query statement below
Select
(Select distinct emp.salary from Employee emp
order by salary desc limit 1,1) as SecondHighestSalary