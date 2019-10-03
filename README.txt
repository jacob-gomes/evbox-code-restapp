JDK version: 1.8.0_221 
Maven Version: 3.6.1
OS: Windows 7
Technology Used: Spring boot 2


===========================================================================================================================

For building the code:

The code uses maven to build the artifactory 

Open a cmd terminal, naviagate to the location of pom.xml(./../evbox-code-restapp)


Use the following command to build:
mvn clean install







===========================================================================================================================
After the build is completed succesfully.
Open a cmd terminal with path ./../evbox-code-restapp/target


To run the application, execute the following command:
java -jar evbox-code-restapp-0.0.1-SNAPSHOT.jar





===========================================================================================================================

Port exposed: 80
Sample URL: http://localhost/chargingSessions/summary