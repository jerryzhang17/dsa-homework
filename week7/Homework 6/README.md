# Campus Taskboard API

A RESTful task management API built with Spring Boot, Spring Data JPA, and H2 for managing campus tasks with database persistence.

---

## How to Run

**Requirements:**
- Java 21 or higher installed
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

## H2 Console

Access the in-memory database directly at:

`http://localhost:8080/h2-console`

| Field | Value |
|-------|-------|
| JDBC URL | `jdbc:h2:mem:taskboarddb` |
| Username | `sa` |
| Password | *(leave blank)* |

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
    "priority": "MEDIUM",
    "createdAt": "2026-04-14T18:20:54",
    "updatedAt": "2026-04-14T18:20:54"
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
    "priority": "MEDIUM",
    "createdAt": "2026-04-14T18:20:54",
    "updatedAt": "2026-04-14T18:20:54"
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
    "priority": "MEDIUM",
    "createdAt": "2026-04-14T18:20:54",
    "updatedAt": "2026-04-14T18:20:54"
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
    "priority": "HIGH",
    "createdAt": "2026-04-14T18:20:54",
    "updatedAt": "2026-04-14T18:21:30"
}
```

Returns `404 Not Found` if the task does not exist.

---

### Delete a Task

`DELETE http://localhost:8080/api/tasks/{id}`

**Response:** `204 No Content`

Returns `404 Not Found` if the task does not exist.

---

### Get Completed Tasks

`GET http://localhost:8080/api/tasks/completed`

**Response:** `200 OK`

```json
[
  {
    "id": 3,
    "title": "Buy groceries",
    "description": "Milk, eggs, bread",
    "completed": true,
    "priority": "LOW",
    "createdAt": "2026-04-14T18:20:54",
    "updatedAt": "2026-04-14T18:20:54"
  }
]
```

---

### Get Incomplete Tasks

`GET http://localhost:8080/api/tasks/incomplete`

**Response:** `200 OK`

```json
[
  {
    "id": 1,
    "title": "Study for midterm",
    "description": "Review chapters 1-5",
    "completed": false,
    "priority": "HIGH",
    "createdAt": "2026-04-14T18:20:54",
    "updatedAt": "2026-04-14T18:20:54"
  }
]
```

---

### Filter by Priority

`GET http://localhost:8080/api/tasks/priority/{priority}`

**Valid values:** `LOW`, `MEDIUM`, `HIGH`

**Example:** `GET http://localhost:8080/api/tasks/priority/HIGH`

**Response:** `200 OK`

```json
[
  {
    "id": 1,
    "title": "Study for midterm",
    "description": "Review chapters 1-5",
    "completed": false,
    "priority": "HIGH",
    "createdAt": "2026-04-14T18:20:54",
    "updatedAt": "2026-04-14T18:20:54"
  }
]
```

Returns `400 Bad Request` if the priority value is invalid.

---

### Search Tasks

`GET http://localhost:8080/api/tasks/search?keyword={keyword}`

Searches both `title` and `description` fields (case-insensitive).

**Example:** `GET http://localhost:8080/api/tasks/search?keyword=homework`

**Response:** `200 OK`

```json
[
  {
    "id": 1,
    "title": "Complete Homework 6",
    "description": "Finish Spring Data JPA assignment",
    "completed": false,
    "priority": "HIGH",
    "createdAt": "2026-04-14T18:20:54",
    "updatedAt": "2026-04-14T18:20:54"
  }
]
```

---

### Get Paginated Tasks

`GET http://localhost:8080/api/tasks/paginated`

**Query Parameters:**

| Parameter | Default | Description |
|-----------|---------|-------------|
| `page` | `0` | Page number (0-indexed) |
| `size` | `10` | Number of tasks per page |
| `sortBy` | `id` | Field to sort by |

**Example:** `GET http://localhost:8080/api/tasks/paginated?page=0&size=5&sortBy=priority`

**Response:** `200 OK`

```json
{
    "content": [...],
    "totalElements": 10,
    "totalPages": 2,
    "size": 5,
    "number": 0
}
```

---

## Task Fields

| Field | Type | Rules |
|-------|------|-------|
| `title` | String | Required, 3–100 characters |
| `description` | String | Optional, max 500 characters |
| `completed` | Boolean | `true` or `false` |
| `priority` | String | `LOW`, `MEDIUM`, `HIGH` |
| `createdAt` | DateTime | Auto-set on creation |
| `updatedAt` | DateTime | Auto-updated on every save |

---

## Video

[https://www.youtube.com/watch?v=zAjPOQ8pFWQ](https://www.youtube.com/watch?v=zAjPOQ8pFWQ)