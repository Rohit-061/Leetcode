# Write your MySQL query statement below
Select p.firstName, p.lastName, s.city, s.state
From Person p
Left join Address s
on p.personId = s.personId;