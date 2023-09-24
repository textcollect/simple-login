# Login Application

One of the assessments from DXC for Java Developer - Fresh Graduate

**Specifications:**

Create a login application.

The UI can be any programming language and the backend must be using Java.

Upon successful login, there should be a welcome page that shows the name, username and role
(manager/user).

If the user has a manager role, the welcome page will have a link to access a restricted webpage.

This restricted webpage can only be accessed by a manager role and not by other user roles.

Do also implement logout functionality.

Notes:
- If the userid or password is not valid, I should remain at the login page with an error message
&quot;Invalid userid or password&quot;.
- All data should be stored in a database.
- The application should demonstrate MVC pattern.

Bonus Question:
- The application should be able to support at least 2 languages (e.g. English, Mandarin).

-------
Sample users for this application:

('Harry', 'user1', 'password2', 'user1@company.com', 'ROLE_USER', 1),

('John', 'manager1', 'password3', 'manager1@company.com', 'ROLE_MANAGER', 1)

------
#### Note
- Database engine used is MySQL
- Run the file "usersTable.sql" first to setup the MySQL database.
- To start the application, run the following command in the root of the application:
```
java -jar target/demo-0.0.1-SNAPSHOT.jar
```