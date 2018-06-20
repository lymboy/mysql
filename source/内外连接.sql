USE day16;

SELECT * FROM employee, dept;

SELECT empName, deptName FROM dept AS d, employee AS e WHERE d.id=e.deptID;

-- 内连接
SELECT deptName, empName  FROM employee INNER JOIN dept ON dept.id=employee.deptID;

-- 左连接
SELECT deptName, empName  FROM employee LEFT OUTER JOIN dept ON dept.id=employee.deptID;

-- 右连接
SELECT deptName, empName  FROM employee RIGHT OUTER JOIN dept ON dept.id=employee.deptID;

-- 自连接
SELECT B.empName, A.empName  FROM employee A LEFT OUTER JOIN employee B ON A.id=B.deptID;