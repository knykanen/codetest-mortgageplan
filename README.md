# codetest-mortgageplan

## Getting Started
This Project requires [Docker](https://www.docker.com/), [Docker Compose](https://docs.docker.com/compose/) and [Maven](https://maven.apache.org/download.cgi) (requires setting up [enviroment variables](https://mkyong.com/maven/how-to-install-maven-in-windows/)). Maven is not required if an IDE such as IntelliJ is used (comes with Maven preinstalled).

## Installing (with Maven installed on your computer)
### 1.
Clone this repo.
### 2.
Open up terminal and CD into the project folder where the Dockerfile and docker-compose.yml files are
### 3.
Use the following command to compile and build the project  
`mvn clean package`
### 4.
Use the following command to build the docker containers. **Notice the dot at the end**  
`docker build -t mortgageplan .`  
If this is your first time starting the service it will take some time to download all of the dependencies needed to run the server.
### 5.
Use the following command to start the containers.  
`docker-compose up`  
The MySQL server is now running on port 3306 and the Spring application is running on port 8080.
### 6.
When the applications are launched, a query will add all the customers from the text file (prospects.txt) into a database. These customers can be seen on  
`localhost:8080/api/customers`
### 7.
A simple web interface is also running on `localhost:8080` which will calculate the monthly payment with the given formula. Note: Invalid input will most likely give errors, which is not recommended.
### 8.
To stop the server press `ctrl + c` in the terminal. Additionally you can then type `docker-compose down` to completely stop the services.

## Installing with Maven in IDE
### 1.
Clone this repo.
### 2.
Open the project in IntelliJ IDE and find the Maven tab in the right side of the IDE  
![Picture](https://i.imgur.com/VsMDNEw.png)
### 3.
Press the `Clean` button and let it run. When it has finished, run `package`, which compiles and builds the project. After the package is compiled, continue to step 4 in the previous installation guide.

## TESTING
Testing can be done with on the Maven tab in IntelliJ IDE by pressing `Test`. If you have Maven installed on your computer, you can run the command  
`mvn test`  
in the terminal while inside the project folder.
