## Task-Management-Spring-Boot-Security-POC | Bootstrap Frontend with Spring Boot Backend and Basic Authentication using Spring Security

Spring Boot CRUD Application, demonstrating basic implmentation of  JPARepository. The application uses embedded JPA Repository for the storage of user information and managing task details. 

## Functionalities
- Basic Authentication (Username/Password Login + Cross Site scripting protection)
- Server side data storage
- CRUD functions: 
  - List All Tasks (Role: USER, ADMIN)
  - View Tasks in Detail (Role: ADMIN)
  - Add New Tasks (Role: ADMIN)
  - Delete existing Task (Role: ADMIN)
- Unit Testing (unfinished)

## Authentication

For  user authentication, the application has user information hardcoded using inMemoryAuthentication (Spring Security). Use one of the following users to access the Portal (http://localhost:8080/)

1. Role: Admin
  - username: demoadmin
  - password: adminpassword

2. Role: User
  - username: demouserone
  - password:demopasswordone

3. Role: User
  - username: usertwo
  - password:dummypasswordtwo

## What's Inside
- Maven
- Springboot Web
- Springboot Security
- Springboot Test 
- Springboot Data (JPA, H2)

## Installation

This is a Maven based Springboot application and to run you need to import the the project to the IDE of your choice and resolve the dependencies. No additional configurations are required.

## Usage

Run as a Spring Boot Application, or Java Application (main: TaskManagementApplication.class) from the IDE. Use browser to navigate to http://localhost:8080/ 

