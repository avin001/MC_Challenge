# Application Overview 
CityApi that exposes RESTful API that checks whether 2 cities are interconnected by road


## Endpoints
	GET
	/connected?origin=city1&destination=city2

## How to run the application
- Please have Maven version `3.3.3` & Java 8 on your system.
- Use command `mvn clean install` to build the project.
- Use command `mvn spring-boot:run` from `MC_Challenge` folder to run the project.
- Place the file City.txt in the folder path C:\City.txt
- Use postman or curl to access `http://localhost:8000/connected?origin=city1&destination=city2` GET endpoint. It will return a 'Yes' if 2 cities are interconnected by road and 'No' if they are not.
