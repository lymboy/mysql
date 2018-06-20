CREATE DATABASE Day15;
USE day15;

CREATE TABLE student(
	id INT,
	NAME VARCHAR(20),
	chinese FLOAT,
	english FLOAT,
	math FLOAT
);

INSERT INTO student(id,NAME,chinese,english,math) VALUES(1,'张小明',89,78,90);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(2,'李进',67,53,95);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(3,'王五',87,78,77);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(4,'李一',88,98,92);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(5,'李来财',82,84,67);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(6,'张进宝',55,85,45);
INSERT INTO student(id,NAME,chinese,english,math) VALUES(7,'黄蓉',75,65,30);

-- 查询所有学生的所有信息
SELECT * FROM student;

-- 查询所有学生的姓名及其对应的英语成绩
SELECT NAME, english FROM student;

-- 过滤表中重复的英语成绩
SELECT DISTINCT english FROM student;

-- 使用别名表示学生分数
SELECT id, NAME, (chinese+english+math) AS grade FROM student;

-- 查询姓名为李一的学生的成绩
SELECT chinese, english, math FROM student WHERE NAME='李一'

-- 查询英语成绩大于等于90分以上的同学
SELECT * FROM student WHERE english>=90;

-- 查询总分大于200分的所有同学
SELECT * FROM student WHERE (chinese+english+math)>200

-- 查询所有姓李的学生的成绩
SELECT english FROM student WHERE NAME LIKE '李%';

-- 查询所有英语大于80或者总分大于200分的同学
SELECT * FROM student WHERE english>80 OR (chinese+english+math)>200;

-- 统计所有学生的总分
SELECT NAME, (chinese+english+math) AS grade FROM student;

-- 给所有学生加上10分特长分
SELECT NAME, (chinese+english+math+10) AS grade FROM student;


