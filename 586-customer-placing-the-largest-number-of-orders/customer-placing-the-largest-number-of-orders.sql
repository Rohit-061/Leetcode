# Write your MySQL query statement below
with cte as(
    select customer_number, count(*) as totalorder
    from Orders
    group by customer_number
)
select customer_number
from cte
order by totalorder desc limit 1;