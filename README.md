# lunch_voting_system
A voting system for deciding where to have lunch

The program is launched using the tomcat server and has configured spring security system (including ROLE_ADMIN, ROLE_USER);
Repository based on MySql database; 

Example credentials for admin:
username: admin@mail.com
password: administrator

list of endpoints with roles:
http://localhost:8080/lunch_voting_system_war_exploded/login access: ROLE_ADMIN, ROLE_USER
http://localhost:8080/lunch_voting_system_war_exploded/registration access: ROLE_ADMIN, ROLE_USER
http://localhost:8080/lunch_voting_system_war_exploded/welcome access: ROLE_ADMIN, ROLE_USER 
http://localhost:8080/lunch_voting_system_war_exploded/restaurant access: ROLE_ADMIN
http://localhost:8080/lunch_voting_system_war_exploded/restaurant/{id}/menu access: ROLE_ADMIN
http://localhost:8080/lunch_voting_system_war_exploded/menu-list access: ROLE_USER
http://localhost:8080/lunch_voting_system_war_exploded/voting access: ROLE_USER
http://localhost:8080/lunch_voting_system_war_exploded/voting access: ROLE_USER
http://localhost:8080/lunch_voting_system_war_exploded/voting-result access: ROLE_USER

lunch_voting_system\src\main\resources\examples - package with request body json form examples for post methods

