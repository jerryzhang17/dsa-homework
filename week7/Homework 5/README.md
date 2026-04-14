# Campus Taskboard API

A RESTful task management API built with Spring Boot for managing campus tasks.
Through APIs we can create and modify tasks on to a local website.

---

## How to Run

**Requirements:**
- Java 17 or higher installed
- Maven installed

**Steps:**
1. Clone or download the project
2. Open a terminal in the project root directory
3. Run the application:

```bash
mvn spring-boot:run
```

The server will start at `http://localhost:8080`

---

## API Endpoints

**Base URL:** `http://localhost:8080`

---

### Get All Tasks
`GET http://localhost:8080/api/tasks`

**Response:** `200 OK`
```json
[
  {
    "id": 1,
    "title": "Study for midterm",
    "description": "Review chapters 1-5",
    "completed": false,
    "priority": "MEDIUM"
  }
]
```

---

### Get Task by ID
`GET http://localhost:8080/api/tasks/{id}`

**Response:** `200 OK`
```json
{
  "id": 1,
  "title": "Study for midterm",
  "description": "Review chapters 1-5",
  "completed": false,
  "priority": "MEDIUM"
}
```

Returns `404 Not Found` if the task does not exist.

---

### Create a Task
`POST http://localhost:8080/api/tasks`

**Request Body:**
```json
{
  "title": "Study for midterm",
  "description": "Review chapters 1-5",
  "completed": false,
  "priority": "MEDIUM"
}
```

**Response:** `201 Created`
```json
{
  "id": 1,
  "title": "Study for midterm",
  "description": "Review chapters 1-5",
  "completed": false,
  "priority": "MEDIUM"
}
```

---

### Update a Task
`PUT http://localhost:8080/api/tasks/{id}`

**Request Body:**
```json
{
  "title": "Study for midterm",
  "description": "Review chapters 1-5",
  "completed": true,
  "priority": "HIGH"
}
```

**Response:** `200 OK`
```json
{
  "id": 1,
  "title": "Study for midterm",
  "description": "Review chapters 1-5",
  "completed": true,
  "priority": "HIGH"
}
```

Returns `404 Not Found` if the task does not exist.

---

### Delete a Task
`DELETE http://localhost:8080/api/tasks/{id}`

**Response:** `204 No Content`

Returns `404 Not Found` if the task does not exist.

---

## Task Fields

| Field | Type | Rules |
|-------|------|-------|
| `title` | String | Required, 3–100 characters |
| `description` | String | Optional, max 500 characters |
| `completed` | Boolean | `true` or `false` |
| `priority` | String | `LOW`, `MEDIUM`, `HIGH` |

---

## Video

[https://youtu.be/0HZbf41Rzr8](https://youtu.be/0HZbf41Rzr8)