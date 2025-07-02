# **Game List** 
![GitHub repo size](https://img.shields.io/github/repo-size/joao123marcos/backEnd_dsList)
![GitHub License](https://img.shields.io/github/license/joao123marcos/backEnd_dsList)


# About this project 
This is an API that I developed in a free course I took at DevSuperior where we worked on a back-end in JAVA with SpringBoot, Hibernate, JPA and SQL. It shows a list of Games with some data such as name, year of the game and platform. The difference with this API is that the user can move the game within the list, placing it in a new position. There is exception handling, for example if the user tries to insert the game in a non-existent position within the list. 

# Application layout 

 - Directory structure 
 ![Directory structure](<Snapshots/Estrutura de diretório.PNG>)  

 - Class
 ![class](<Snapshots/Classe Game.PNG>) 

 - Controllers 
 ![controllers](<Snapshots/Game List Controller.PNG>) 

 - Service
 ![service](<Snapshots/Game list service.PNG>) 

 - Exceptions
 ![exception](<Snapshots/Tratamento de exceção.PNG>) 

 - Application Run
 ![run](<Snapshots/aplicação rodando.PNG>) 

- Postman
![postman](Snapshots/postman.PNG)  


# Technologies used 

- Java
- SpringBoot
- Hibernate
- JPA
- SQL
- Postgre for profile dev
- H2 for profile test 

# How to run this project

```bash
#clone this repository using ssh for your machine

git clone git@github.com:joao123marcos/backEnd_dsList.git
```
```bash
#Enter in directory dowloaded

cd backEnd_dsList
```
```bash
#Run project maven

mvnw spring-boot:run
```
# Author 
João Marcos dos Santos Pires  

Linkedin: www.linkedin.com/in/joao-marcos-pires-642585155  
Email: joaomarcos.spires@gmail.com