-- 显示所有数据库
SHOW DATABASES;

-- 选择day16数据库
USE day16;

-- 往dept表添加数据
INSERT INTO dept(id, deptName) VALUES(1, '软件开发部'),(2, '应用维护部'), (3, '秘书部');

-- 往employee表插入数据
INSERT INTO employee VALUES(1,'张三',1), (2,'李四',1), (3,'王五',2), (4,'陈六',3);

-- 外键约束, 此命令失败
INSERT INTO employee VALUES(5, '二狗', 4);
-- 有了外键约束, 先添加主表, 再添加副表
INSERT INTO dept VALUES(4, '公关部');

-- 修改数据时先修改副表
UPDATE dept SET id=5 WHERE id=4;
UPDATE employee SET deptID=3 WHERE id=4;

-- 添加主表数据
INSERT INTO dept(id, deptName) VALUES(4, '运维部');
-- 添加副表数据
INSERT INTO employee(id, empName, deptID) VALUES(6, '老九', 4);

DESC employee;
SELECT * FROM dept;
SELECT * FROM employee;