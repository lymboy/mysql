DELIMITER $
CREATE PROCEDURE pro_test()
BEGIN
    SELECT * FROM employee;
END $

CALL pro_test();

-- 输入参数
DELIMITER $
CREATE PROCEDURE pro_findById(IN eid INT)
BEGIN
    SELECT * FROM employee WHERE id=eid;
END $

CALL pro_findById(3);

-- 输出参数
DELIMITER $
CREATE PROCEDURE pro_testOut(OUT str VARCHAR(20))
BEGIN
    SET str='Hello Java';
END $

CALL pro_testOut(@NAME);
SELECT @NAME;

-- 输入输出参数
DELIMITER $
CREATE PROCEDURE pro_testInOut(INOUT n INT)
BEGIN
    SELECT n;
    SET n=6636;
END $

SET @n=666;
CALL pro_testInOut(@n);
SELECT @n;