# Write your MySQL query statement below
DELETE P1 FROM Person as P1
JOIN Person as P2
on P1.email = P2.email 
where P1.id>P2.id;