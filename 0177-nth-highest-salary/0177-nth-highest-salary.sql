-- CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
-- BEGIN
-- DECLARE M INT;
-- SET M=N-1;
--   RETURN (
      
--           (
--               SELECT DISTINCT salary
--               FROM Employee
--               ORDER BY salary DESC
--               LIMIT 1 OFFSET M
--           )
--   );
-- END

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE M INT;
  SET M=N-1;
  RETURN (
    WITH RankedSalaries AS (
      SELECT DISTINCT salary
      FROM Employee
      ORDER BY salary DESC
    )
    SELECT salary
    FROM RankedSalaries
    LIMIT 1 OFFSET M
  );
END;

