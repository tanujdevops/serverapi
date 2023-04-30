# Server API

This is a Java REST API that allows you to search for, create, and delete "server" objects.

API Endpoints
```
GET /servers
```
Returns all servers when no parameters are passed. Returns a single server when a server ID is passed as a parameter. Returns 404 if the server is not found.

Request Parameters
id (optional) - The ID of the server to return.
Example Request
```
GET /servers?id=123
```

Example Response

```
{
  "id": "123",
  "name": "my centos",
  "language": "java",
  "framework": "django"
}
```

PUT /servers
Creates a new server. The server object is passed as a JSON-encoded message body.

Example Request

PUT /servers
{
  "id": "123",
  "name": "my centos",
  "language": "java",
  "framework": "django"
}
Example Response

{
  "id": "123",
  "name": "my centos",
  "language": "java",
  "framework": "django"
}
DELETE /servers/{id}
Deletes a server by ID.

Example Request

DELETE /servers/123
GET /servers/search
Searches for servers by name. Returns 404 if no servers are found.

Request Parameters
name - The name of the server to search for.
Example Request

GET /servers/search?name=centos
Example Response

[
  {
    "id": "123",
    "name": "my centos",
    "language": "java",
    "framework": "django"
  }
]
Technologies
This application is built using Spring Boot and MongoDB.

Usage
Clone the repository.
Open the project in your preferred IDE.
Run the application.
Use an HTTP client like Postman to send requests to the API.
