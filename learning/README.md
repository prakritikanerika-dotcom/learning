# Spring Boot Student REST API

This is a simple beginner-friendly Spring Boot REST API project for learning basic REST concepts.

It has:

- one GET API to return students
- one POST API to add a student in memory
- no database

## Project structure

- `LearningApplication.java`  
  Main Spring Boot entry point. It starts the application.

- `model/Student.java`  
  Simple Java class that represents a student.

- `service/StudentService.java`  
  Stores student data in memory and contains the business logic.

- `controller/StudentController.java`  
  Handles HTTP requests and returns JSON responses.

## Important annotations

- `@SpringBootApplication`  
  Marks the main Spring Boot application class.

- `@RestController`  
  Tells Spring that this class handles REST APIs and returns JSON.

- `@RequestMapping("/api/students")`  
  Sets the base URL for all student APIs.

- `@GetMapping`  
  Maps HTTP GET requests.

- `@PostMapping`  
  Maps HTTP POST requests.

- `@RequestBody`  
  Reads JSON from the request body and converts it into a Java object.

- `@Service`  
  Marks the service class as a Spring service component.

## API endpoints

### 1) Get all students

- Method: `GET`
- URL: `http://localhost:8080/api/students`

#### Sample Postman request

- Method: `GET`
- URL: `http://localhost:8080/api/students`
- Headers:
  - `Accept: application/json`
- Body: none

#### Example response

```json
[
  {
    "id": 1,
    "name": "Rahul",
    "age": 20
  },
  {
    "id": 2,
    "name": "Anita",
    "age": 22
  }
]
```

### 2) Create a student

- Method: `POST`
- URL: `http://localhost:8080/api/students`

#### Sample Postman request

- Method: `POST`
- URL: `http://localhost:8080/api/students`
- Headers:
  - `Content-Type: application/json`
  - `Accept: application/json`
- Body:

```json
{
  "name": "Aman",
  "age": 21
}
```

#### Example response

```json
{
  "id": 3,
  "name": "Aman",
  "age": 21
}
```

## Request payload

For the POST API, send JSON like this:

```json
{
  "name": "Aman",
  "age": 21
}
```

The `id` can be sent too, but if it is not provided, the application generates one in memory.

## Response payload

The API returns JSON objects:

- GET returns a JSON array of students
- POST returns the created student as JSON

## How it works

- The application starts with two sample students already in memory.
- When you call `GET /api/students`, it returns the current list.
- When you call `POST /api/students`, the new student is added to the in-memory list.
- Data is lost when the application stops because there is no database.

## How to run the application

From the project root:

```bash
./gradlew bootRun
```

On Windows PowerShell:

```powershell
.\gradlew.bat bootRun
```

The application runs on:

```text
http://localhost:8080
```

## Notes for beginners

If you are learning Spring Boot, focus on this flow:

1. Client sends an HTTP request
2. Controller receives it
3. Service handles the logic
4. Java object is converted to JSON automatically

