-- 创建部门表
CREATE TABLE dept(
    id INT PRIMARY KEY,
    deptName VARCHAR(20)
);

-- 创建员工表
CREATE TABLE employee(
    id INT PRIMARY KEY,
    empName VARCHAR(20),
    deptID INT,
    CONSTRAINT employee_dept_fk FOREIGN KEY(deptID) REFERENCES dept(id)
);