SELECT d.name AS Department,
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
WHERE ranked.rnk <= 3;