
# Insurance Management Platform 

This is an insurance management platform that allows users to manage insurance policies, clients, and claims.

## Configurations

| Components |Technologies                |
| :-------- |:------------------------- |
| Backend | Spring Boot 3.0.5, Java 17 |
| Security | Spring Security, Form |
| Datebase | MYSQL, JPA-Hibernate |
| Server Build | Maven |
| API Testing | Postman |
| IDE | IntelliJ, VS Code|

## Deployment

__1.__ To clone this repository copy following command

```bash
  git clone https://github.com/hemantDwivedi/insurance-management-platform.git
```

* Or just download .zip file: Click on __[Code](https://github.com/hemantDwivedi/insurance-management-platform/archive/refs/heads/main.zip)__ and then unzip the file.

__2.__ Open project folder in IntelliJ and wait few seconds to download all maven dependencies.

__3.__ Open MYSQL Command Line Client, enter your password, and run the following command for creating database

```bash
  create database insurance_db;
```

* ` Or you can also use MYSQL Workbench for creating 'insurance_db' database.`

__4. Configuration application.yml__

* _Change the following:_
```
username: [your_database_username]-[by default it's 'root']
password: [your_password]
```
* _Change port number in case you have different port number_
```url: jdbc:mysql://localhost:[your_port_number]/insurance_db```

__5.__ Run the application __'InsuranceManagementApplication.java'__ file.
## API Reference

### Postman

__1.__ Download __[API.json](https://drive.google.com/file/d/1JVqcaRkkDZcAIDdeUFf6_mje_fYWLF3z/view?usp=sharing)__ file.

__2.__ Open Postman > click Collections > click on import > drag and drop above downloaded `.json` file.

* Now you can test all APIs


### Client GET APIs
#### Get all clients

```http
  GET /api/clients
```

| Authorization | Description |
| :---------- | :---------- |
| `Basic Auth` | **Required**. [username] - admin [password] - admin |

* _username and password is: admin, admin_

#### Get a specific Client

```http
  GET /api/clients/$clientId
```

| Parameter | Description                       |
| :-------- |:-------------------------------- |
| `id`      | **Required**. Id of client to fetch |


### Claim GET APIs
#### Get all claims

```http
  GET /api/claims
```

| Authorization | Description |
| :---------- | :---------- |
| `Basic Auth` | **Required**. [username] - admin [password] - admin |

* _username and password is: admin, admin_

#### Get a specific Claim

```http
  GET /api/clients/$claimId
```

| Parameter | Description                       |
| :-------- |:-------------------------------- |
| `id`      | **Required**. Id of claim to fetch |

### Policy GET APIs
#### Get all clients

```http
  GET /api/policies
```

| Authorization | Description |
| :---------- | :---------- |
| `Basic Auth` | **Required**. [username] - admin [password] - admin |

* _username and password is: admin, admin_

#### Get a specific Policy

```http
  GET /api/clients/$policyId
```

| Parameter | Description                       |
| :-------- |:-------------------------------- |
| `id`      | **Required**. Id of policy to fetch |


## Documentation

* [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)

* [MYSQL](https://dev.mysql.com/doc/workbench/en/)

