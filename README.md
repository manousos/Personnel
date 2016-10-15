# Personnel
Sample web application.   Hibernate, Spring and ZK Framework

##Database Structure##
The project’s database is a very simple and small database with just 5 tables:
Employees 
This table contains the company’s staff. Each record in this table represents an Employee. We have already mapped the Employee class with this table:
/homework/src/com/personnel/components/Employee.java
/homework/src/com/personnel/components/Employee.hbm.xml

SeminarTypes 
The SeminarType represents a type of seminar. We could imagine the SeminarType as a seminar class where each employee may attend. 
Example of titles of seminar types could be: “Marketing Strategies”, “Accounting Procedures” etc

Seminars 
Each time an employee attends a specific seminar class (SeminarType) then a new record should be created in this table to keep track of the seminars each employee attends. 
Notice that “seminarTypeId” and “employeeId” are foreign keys in this table and these two fields can ensure the uniqueness of each record. 
Each employee may attend a seminar (or else SeminarType) only once.

Payrolls 
Each record represents the identity of a monthly payroll. For example: “Payroll of June”.

EmployeePayrolls 
Each record in this table represents the payroll of a specific employee for a given month.

##The Data Acces Layer##
contains the classes that gives an additional level of abstraction over data access.

##The Service Layer##
contains the classes representing the service layer. Service layer exposes business logic.
The services are classes responsible to execute all necessary database queries (via dao) and apply also any additional business logic.

##Presantation Layer##
Contains all .zul  web pages. Use MVVM architecture with ZK Framework.

employees.zul - Display all employees.
employee-editor.zul - Add - Edit - Delete an employee.
seminar-types.zul - Display all seminars.
seminar-type-editor.zul - Add - Edit - Delete a seminar.
employee-seminars.zul - Display the seminars attended by a specific employee.
employee-seminar-editor.zul - Add or edit a seminar attendance for a specific employee.
payrolls.zul - Display a list of all payrolls and  make a batch calculation of a payroll for all employees.
payroll-editor.zul - add or edit a payroll issue.
