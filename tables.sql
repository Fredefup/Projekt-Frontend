alter table Departments drop foreign key FK_employee;
drop table Employees;
drop table Departments;
---

create table Departments (
  id int primary key,
  name varchar(40) not null
  );

create table Employees (
  id int primary key,
  name varchar(80) not null,
  salary float not null,
  department_id int not null references Departments(id)
  );

alter table Departments
add column manager_id int constraint FK_employee 
references Employees(id);
