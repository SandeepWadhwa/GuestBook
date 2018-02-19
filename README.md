# GuestBook

Sample app using SpringBoot, Derby, Maven, tomcat etc.

Embedded Tomcat server runs at 8050. So in order to access the various resources use the following resource URLs.

POST http://localhost:8050/guest-api/guests  --- to create a new guest entry ... 

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

GET http://localhost:8050/guest-api/guests

Get the resource using Id as -

GET http://localhost:8050/guest-api/guests/1/

Response would be -- 

{
    "guestId": 1,
    "guestName": "SandeepWadhwa1",
    "comment": "Checked-on-18-Feb at 6 PM",
    "createdDateTime": "2018-30-19 12:30:26"
}

Delete the resource using {id} 

DELETE http://localhost:8050/guest-api/guests/1/

Again verify GET request to get all the resources -- 

GET http://localhost:8050/guest-api/guests

In order toupdate the resource use PUT

PUT http://localhost:8050/guest-api/guests/2/

Send body as:

{
	"guestName":"SandeepWadhwa2",
	"comment":"Checked-on-19-Feb at 7 PM"
}

Again verify GET request to get updated resource -- 

GET http://localhost:8050/guest-api/guests/2/


