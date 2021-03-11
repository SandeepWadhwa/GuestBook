# springboot-guestbook-api

Sample CRUD REST APIs using Java8, SpringBoot (2.2.8 Release), Derby (10.14.2.0 - An in-memory database) , Maven, Embedded tomcat to maintain GuestBook entry.

Pre-requisites to be installed

1. JDK 8
2. Maven

Steps to execute the application locally:

1. Clone The repo
2. Open The command prompt
3. mvn clean install (Please make sure that you are in the directory where pom.xml is present and Maven is configured)
4. Change the directory to target folder
5. Run the command "java -jar springboot-guestbook-api-1.0.0.jar"

Embedded Tomcat server runs at 8050. So in order to access the various resources use the following resource URLs.

POST http://localhost:8050/api/guests  --- to create a new guest entry ... 

Send body as:

{
	"guestName":"SandeepWadhwa1",
	"comment":"Checked-on-18-Feb at 6 PM"
}

{
	"guestName":"SandeepWadhwa2",
	"comment":"Checked-on-19-Feb at 6 PM"
}

Execute GET request to retrieve the list of all the guests. 

GET http://localhost:8050/api/guests

Get the resource using Id as -

GET http://localhost:8050/api/guests/1/

Response would be -- 

{
    "guestId": 1,
    "guestName": "SandeepWadhwa1",
    "comment": "Checked-on-18-Feb at 6 PM",
    "createdDateTime": "2018-30-19 12:30:26"
}

Delete the resource using {id} 

DELETE http://localhost:8050/api/guests/1/

Again verify GET request to get all the resources -- 

GET http://localhost:8050/api/guests

In order toupdate the resource use PUT

PUT http://localhost:8050/api/guests/2/

Send body as:

{
	"guestName":"SandeepWadhwa2",
	"comment":"Checked-on-19-Feb at 7 PM"
}

Again verify GET request to get updated resource -- 

GET http://localhost:8050/api/guests/2/

Postman collection is also present in the repo to verify the different operations.


