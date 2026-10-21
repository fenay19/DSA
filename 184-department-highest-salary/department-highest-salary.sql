
WITH maxsal AS (
    SELECT
        e.id,
        e.name AS employee,
        e.salary,
        d.name AS department,
        DENSE_RANK() OVER (
            PARTITION BY d.id
            ORDER BY e.salary DESC
        ) AS rnk
    FROM Employee e
    JOIN Department d
        ON e.departmentId = d.id
)
SELECT
    department AS Department,
    employee AS Employee,
    salary AS Salary
FROM maxsal
WHERE rnk = 1;
