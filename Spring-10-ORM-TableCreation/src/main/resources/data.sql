INSERT INTO EMPLOYEES(id,name)
VALUES(1,'Mike Smith');

-- INSERT INTO student(id, first_name,last_name,email)
-- VALUES(1, 'Mike',' Smith','mike@cydeo.com');

--postgres will provide the id(primary key) automatically, if you add the @Id, @Entity, and @GenerateValue()
INSERT INTO student(first_name,last_name,email)
VALUES('Mike',' Smith','mike@cydeo.com');

