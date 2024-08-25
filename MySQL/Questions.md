Write a query to fetch the EmpFname from the EmployeeInfo table in the upper case and use the ALIAS name as EmpName.





Write a query to fetch the number of employees working in the department ‘HR’.


Write a query to get the current date.
Write a query to retrieve the first four characters of  EmpLname from the EmployeeInfo table.
Write a query to fetch only the place name(string before brackets) from the Address column of EmployeeInfo table.
Write a query to create a new table that consists of data and structure copied from the other table.
Write q query to find all the employees whose salary is between 50000 to 100000.
Write a query to find the names of employees that begin with ‘S’
Write a query to fetch top N records.
Write a query to retrieve the EmpFname and EmpLname in a single column as “FullName”. The first name and the last name must be separated with space.

https://www.edureka.co/blog/interview-questions/sql-query-interview-questions#createtable

1. Diff between Count(Coulum) and Count(*)
SELECT COUNT(COMM), COUNT(*) FROM EMP GROUP BY DEPTNO;

2. Find the Employee who are not getting Commision.
SELECT * FROM EMP WHERE comm IS NULL;

2. Find the Employee who are getting Commison.
SELECT * FROM EMP WHERE comm IS NOT NULL;

2. Find the error in the below query, and how to rectify it.
SELECT  e.*, length(ename) as len from emp e where len = 4;	
SELECT  e.ename, e.hiredate, YEAR(e.hiredate) as year FROM emp e where year = 1;

Select * from (SELECT e.*, year(e.hiredate) as year FROM EMP e);
Every derived table must have its own alias.

0. Find total salary of all the Employees
SELECT sum(sal) FROM EMP e;

1. Find the MAX Employees job in Employee table.

SELECT deptno, count(*) AS workers
FROM emp
GROUP BY deptno
order by workers DESC limit 1;



2. Also find Secound MAX Employees job in Employee table.



3. Find the Jobs where more then 5 employees are working.


2. Count the rows
SELECT count(*) FROM EMP e;

2. Is this work?

SELECT deptno,count(*) FROM EMP e group by deptno ORDER BY deptno;

SELECT job FROM EMP e group by deptno having count(*) > 4 ORDER BY job;

SELECT e.*, d.* from emp e JOIN dept d ;

SELECT deptno, count(*) AS workers
FROM emp
GROUP BY deptno
order by workers;

3. How do you sikp 3 rows and shows 3th records onwards.
SELECT * 
FROM emp
skip: pageNumber(0 to N) * pageSize
Ex: Limit 0 * 3, 3  
# LIMIT 0, 3; First 3 records
# LIMIT 3, 3; Next 3 records
# LIMIT 6, 3; Next 3 records
# LIMIT 9, 3; Next 3 records





1. Find Employees who worked in 1981
SELECT * FROM (SELECT  e.ename, e.hiredate, YEAR(e.hiredate) as year FROM emp e) E
where E.year = 1981;


2. Group Employees based on length of the name.
SELECT e.len, count(e.len) AS COUNT FROM (SELECT  e.*, length(ename) as len from emp e) e group by e.len;	

4. Group Employee based on the Year of join.
SELECT year, count(*) FROM (SELECT e.*, year(e.hiredate) as year FROM EMP e) AS e GROUP BY year;



4. Group Employee based on the Month of join.

3. Fine the max, nth, 2nd salaried employee.
4. Show Salary + Commition
4. 

1. Find Employees who's name has exactly 4 characters.
SELECT * FROM (SELECT  e.*, length(ename) as len from emp e) e where e.len = 4;	


