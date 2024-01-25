# account
Spring Boot 3 with JPA and Jersey


Hur/vad göra
============

- Att bygga: mvn clean package 
- Att köra:  mvn spring-boot:run    (java -jar target\account-0.0.1-SNAPSHOT.jar)

- Debug: mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5000 -Dserver.port=8080"
 och sen i Eclipse meny välj "Debug configurations..." -> och skapa en "Remote Java Application", 
 sätt Host: localhost , Port: 5000   
 se \debug_account_settings.GIF


In-memory databasen
----------------------------
http://localhost:8080/h2-console/login.do   (lösen: password)

