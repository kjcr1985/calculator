# calculator
repository for the Sanitas technical test

Steps to generate and run the api

Requirements to install the Calculator api
install the JDK 17 java version
Install and configure Maven

- Clone the Git repository 
https://github.com/kjcr1985/calculator.git 
either from git or any repository manager.

-Proceed to install the tracer the .jar file, which is added in the repository itself (lib folder):

mvn install:install-file -Dfile=./lib/tracer-1.0.0.jar -DgroupId=io.corp.calculator -DartifactId=tracer -Dversion=1.0.0 -Dpackaging=jar

Compile the .jar of the calculator api with the command: "mvn clean install" from the command line.
this is launched from the root folder of the project

Run the calculator api

command java -jar target\calculator-0.0.1-SNAPSHOT.jar

The application documentation can be accessed from the following path 
http://localhost:8080/doc/swagger-ui/index.html

