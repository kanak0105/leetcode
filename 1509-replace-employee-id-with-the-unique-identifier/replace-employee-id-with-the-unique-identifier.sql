# Write your MySQL query statement below
select name, unique_id from Employees as e1 LEFT JOIN EmployeeUNI as e2 ON e1.id= e2.id ;