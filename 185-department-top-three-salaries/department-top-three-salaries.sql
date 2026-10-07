/*SELECT d.name AS Department,
       ranked.name AS Employee,
       ranked.salary AS Salary
FROM (
    SELECT name, salary, departmentId,
           DENSE_RANK() OVER (
               PARTITION BY departmentId
               ORDER BY salary DESC
           ) AS rnk
    FROM Employee
) AS ranked
JOIN Department d
    ON ranked.departmentId = d.id
WHERE ranked.rnk <= 3;*/

SELECT d.name as Department,
       e.name as Employee,
       e.salary as salary      
FROM Employee e
JOIN 
Department as d
 ON e.departmentId = d.id
WHERE 3 > (
    SELECT COUNT(DISTINCT e2.salary)
    FROM Employee e2
    WHERE e2.departmentId = e.departmentId 
    and e.salary < e2.salary
);