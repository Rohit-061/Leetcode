# Write your MySQL query statement below
Select product_id, 10 as price
from Products 
group by product_id
having MIN(change_date) > '2019-08-16'
union all
select P.product_id, P.new_price as price
From Products P inner join(
    select product_id, MAX(change_date) as max_date
    from products
    where change_date <= '2019-08-16'
    group by product_id
) as R
on P.product_id = R.product_id and P.change_date = R.max_date;