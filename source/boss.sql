USE day16;

DROP TABLE boss;

CREATE TABLE boss(id INT PRIMARY KEY, NAME VARCHAR(20), gender VARCHAR(10));

DESC boss;

INSERT INTO boss(id, NAME, gender) VALUES(1, 'John', 'man'), (2, 'Kevin', 'woman');

SELECT * FROM boss;

UPDATE boss SET NAME='Lily' WHERE id=2;

DELETE FROM boss;