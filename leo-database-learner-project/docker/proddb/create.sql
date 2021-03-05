CREATE TABLE test(id NUMERIC(2), name varchar(14));

INSERT INTO test VALUES (1,'first');
INSERT INTO test VALUES (2,'second');

CREATE TABLE PERSON(ID NUMERIC(2) CONSTRAINT PERSON_PRIMARY_KEY PRIMARY KEY,
                    NAME VARCHAR(60));

INSERT INTO PERSON VALUES (1,'Marah Steigersdorfer');
INSERT INTO PERSON VALUES (2,'Vanessa Primetzhofer');
INSERT INTO PERSON VALUES (3,'Isabel Turner');
INSERT INTO PERSON VALUES (4,'Max Mustermann');
INSERT INTO PERSON VALUES (5,'Erika Musterfrau');
INSERT INTO PERSON VALUES (6,'Otto Normalverbraucher');

-- INSERT INTO QUESTION VALUES ('text01','Select * from emp e order by e.ename',2,,'Marah Steigersdorfer');
-- INSERT INTO QUESTION VALUES ('text02','Select * from dept d order by d.deptno',2,,'Marah Steigersdorfer');
-- INSERT INTO QUESTION VALUES ('text03','Select e.ename from emp e order by e.ename',2,,'Marah Steigersdorfer');
-- INSERT INTO QUESTION VALUES ('text04','Select * from salgrade',1,,'Marah Steigersdorfer');
