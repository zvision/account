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


Ex på anrop
===========
GET: 
 curl http://localhost:8080/api/v1/accounts     	// hämta alla konto
 curl http://localhost:8080/api/v1/accounts/yahoo	// hämta specifik kontonamn 
 curl http://localhost:8080/api/v1/accounts/yah		// del av kontonamn



POST:
 curl -X POST "http://localhost:8080/api/v1/accounts" -H "Content-Type: application/json" -d "{\"name\":\"kalle@kulle.com\", \"uid\":\"kalle\", \"pwd\":\"Kalle30\"}"


DELETE:
 curl -X DELETE "http://localhost:8080/api/v1/accounts/1" 
 
PUT:
 TBD 
 