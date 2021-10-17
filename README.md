# Rydesg

Ryde Sg App 
The Application handle flowing functionality of the user details.
• Add this “host” url pattern for all request as common variable. In postman can be setup in 
“Environments”’
• Read the column 4 “Note” for mandatory fields
• Here Authentication not handle, and some error scenario handle
• ACID property handle ,not handling high Availability
• Together with document shared
o Application - Rydesg (written in java, I need some more time to do in python)
o Database (Mysql) - ryde_db to create db and export using user_data_csv file OR
Use ryde_user_data_with_db create db with data
o Postman request
{{host}}: localhost:8080/api/ryde
functionality Api Call Request body and Description note 
Add User {{host}}/user/addUser {
"name": "Thavaraja Johnson Piratharsanna",
"dob": "1989-04-01",
"address": "john tampines",
"description": "adding user final test"
}
Here ID 
auto 
generated 
and ID 
only 
unique 
name can 
be 
duplicate
View All 
User
{{host}}/user/getAllUser Get request no need body, 
we can handle pagination, here not handle the 
pagination
It return all 
exist user
Edit user {{host}}/user/editUser {
"id" : "9",
"name": "reyde-test9 to edit user",
"dob": "1989-04-01",
"address": "john tampines edit",
"description": "first test"
}
ID must be 
present 
otherwise 
handle 
exception 
will 
response
Delete User {{host}}/user/deleteUser {
"id" : "11"
}
ID must be 
present 
otherwise 
handle 
exception 
will 
response
 
To run Application (by two way can be do) 
1. Using Command line or Terminal 
o mvn clean install
▪ need JAVA_HOME and MAVEN HOME
o mvn spring-boot:run
2. Using editor (STS) 
o Import as “Maven Existing project” 
o Do the clean build 
o Then run using run/debug button 
About libraries
o Lombok used for log purpose not data level
o Spring boot starter project 
o Java 8 used
o development did in STS (Spring boot tool => eclipse)
