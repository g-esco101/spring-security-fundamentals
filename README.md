# Spring Security Fundamentals
Concerns the fundamentals of Spring Security using xml configuration.

Covers user storage in memory and in a database, client integration with taglibs, password storage, customizing the UI, method level security as well as method level permissions, basic LDAP configuration, and forcing connections over HTTPS.

The fitnessTracker application is a scaffolding app and not meant to be comprehensive. It is simply used demonstrate the features of Spring Security.

Considering to update this to use the latest technologies as well as other technologies (e.g., jpa) and java configuration. 

## Technologies
java 8

MySQL 5.7

Maven 3.6.3

Tomcat 7

Eclipse IDE for Enterprise Java Developers 2019-12

## Run
### Import the project into Eclipse
Select File > Import

Select Maven > Existing Maven Projects and click Next

In Root Directory, browse to the FitnessTracker directory and select it

Click Next and then click Finish

### Deploy to a server
Select Windows > Show View > Servers

Under the Servers tab, right click and select New

Select Apache > Tomcat v7.0 Server and then click Next

Click the Download and Install button if you don't have it installed

Click next

Select the FitnessTracker and add it to the server

Click Finish

Click the play button to start the server

Open a browser and enter https://localhost:8443/FitnessTracker/index.jsp or http://localhost:8080/FitnessTracker/index.jsp

Login with user bryan, mark, or chris (password is secret) prior to adding LDAP, i.e. when using MySQL for authentication server. After LDAP, which is the current state, get usernames and password from users.ldif file (e.g, login as rod with password koala).


