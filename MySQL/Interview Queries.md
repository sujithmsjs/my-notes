SELECT * FROM emp e INNER JOIN dept d ON  e.deptno = d.deptno;

SELECT e.*,  DENSE_RANK() OVER (order by sal desc) as rankd FROM emp e;

SELECT *  FROM (SELECT e.*,  DENSE_RANK() OVER (order by sal desc) as rankk FROM emp e) AS a WHERE rankk=2;

## First
SELECT * FROM emp ORDER BY sal DESC limit 3;

SELECT DISTINCT job FROM emp;
SELECT DISTINCT job, deptno FROM emp;


## Joins

# Natural Join
SELECT * FROM emp JOIN dept;
SELECT * FROM emp NATURAL JOIN dept;
SELECT count(*) from emp; # 14
SELECT count(comm) from emp; # 4
SELECT * FROM emp e INNER JOIN dept d ON e.deptno = d.deptno;

# Give salary ranks in each department
SELECT e.*, dense_rank() over (partition by deptno order by sal desc) from emp e;


SELECT * FROM(SELECT e.*, dense_rank() over (partition by deptno order by sal desc) from emp e) as a order by deptno;



SELECT * from (SELECT *,dense_rank() over (order by sal desc)r from emp) d WHERE d.r = 4 ;


SELECT * FROM emp order by sal desc limit 1;

# Find max salary not including a department
SELECT max(sal) from emp
where sal < (select max(sal) from emp);

SELECT job, count(*) as count, sum(sal) as sum from emp where deptno = 30 group by job;

SELECT * from ( 
SELECT distinct sal from emp order by sal desc limit 2) as emp order by sal limit 1;


# Find 2nd highest salaried employee
select * from (SELECT e.*, dense_rank() over (order by sal desc) as dr from emp e) as max
  where max.dr=2;

select * from dept;
select e.ename, d.dept from emp e inner join dept d;

# Using top
select count(e.ename),d.dname from emp e inner join dept d
on e.deptno=d.deptno
group by d.dname
having count(e.ename) <= 5
order by count(e.ename) asc;

#  group by d.dname having count(d.dname) = 5

# Find the max average salary job.
SELECT job, avg(sal), count(sal), sum(sal) from emp
group by job
order by avg(sal) desc
limit 1;


# Nth salary employee
select * from (SELECT e.*, dense_rank() over (order by sal desc) as dr from emp e) e
where e.dr <= 3;

select * from (select e.*, dense_rank() over (order by sal desc) dr from emp e) as emp
where emp.dr = 2;

# Find First records in all 3 departments
select e.*, row_number() over (partition by deptno) from emp e;

















