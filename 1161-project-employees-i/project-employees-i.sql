# Write your MySQL query statement below
select project_id , ROUND(AVG(e.experience_years), 2) AS average_years
from Project as p
inner join Employee as e
on p.employee_id = e.employee_id 
group by project_id;