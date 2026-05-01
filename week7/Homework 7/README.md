# Campus Taskboard API

A RESTful task management API built with Spring Boot, Spring Data JPA, and H2. Features robust exception handling, DTOs, soft delete, request logging, and health monitoring.

---

## How to Run

**Requirements:**
- Java 21 or higher
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

| Field    | Value                      |
|----------|----------------------------|
| JDBC URL | `jdbc:h2:mem:taskboarddb`  |
| Username | `sa`                       |
| Password | *(leave blank)*            |

---

## New Features (Homework 7)

### Exception Handling
- Custom exceptions: `TaskNotFoundException`, `InvalidTaskDataException`
- Global exception handler with `@RestControllerAdvice`
- Consistent error responses with timestamp, status, error, message, and path
### DTOs (Data Transfer Objects)
- `TaskRequest` — validates incoming data from the client
- `TaskResponse` — controls what fields are returned to the client (hides internal fields like `deleted`)
### Soft Delete
- Tasks are never permanently removed from the database
- `DELETE /api/tasks/{id}` sets `deleted = true`
- `GET /api/tasks` only returns non-deleted tasks
- `PUT /api/tasks/{id}/restore` restores a deleted task
### Request Logging
- Every request is logged with method, URI, status code, and duration
- Logs appear in the terminal when the app is running
### Health Monitoring
- Actuator health endpoint available at `/actuator/health`
---

## API Endpoints

**Base URL:** `http://localhost:8080`

---

### Get All Tasks

`GET /api/tasks`

Returns only non-deleted tasks.

**Response:** `200 OK`

```json
[
  {
    "id": 1,
    "title": "Study for midterm",
    "description": "Review chapters 1-5",
    "completed": false,
    "priority": "MEDIUM",
    "createdAt": "2026-04-30T21:00:00",
    "updatedAt": "2026-04-30T21:00:00"
  }
]
```

---

### Get Task by ID

`GET /api/tasks/{id}`

**Response:** `200 OK`

Returns `404 Not Found` if the task does not exist.

```json
{
  "id": 1,
  "title": "Study for midterm",
  "description": "Review chapters 1-5",
  "completed": false,
  "priority": "MEDIUM",
  "createdAt": "2026-04-30T21:00:00",
  "updatedAt": "2026-04-30T21:00:00"
}
```

---

### Create a Task

`POST /api/tasks`

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

Returns `400 Bad Request` if validation fails (e.g. missing title, title too short).

---

### Update a Task

`PUT /api/tasks/{id}`

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

Returns `404 Not Found` if the task does not exist.

---

### Delete a Task (Soft Delete)

`DELETE /api/tasks/{id}`

Sets `deleted = true`. The task is hidden from all list endpoints but remains in the database.

**Response:** `204 No Content`

Returns `404 Not Found` if the task does not exist.

---

### Restore a Task

`PUT /api/tasks/{id}/restore`

Restores a soft-deleted task by setting `deleted = false`.

**Response:** `200 OK`

Returns `404 Not Found` if the task does not exist.

---

### Get Completed Tasks

`GET /api/tasks/completed`

**Response:** `200 OK`

---

### Get Incomplete Tasks

`GET /api/tasks/incomplete`

**Response:** `200 OK`

---

### Filter by Priority

`GET /api/tasks/priority/{priority}`

**Valid values:** `LOW`, `MEDIUM`, `HIGH`

**Example:** `GET /api/tasks/priority/HIGH`

Returns `400 Bad Request` if the priority value is invalid.

---

### Search Tasks

`GET /api/tasks/search?keyword={keyword}`

Searches both `title` and `description` fields (case-insensitive).

**Example:** `GET /api/tasks/search?keyword=homework`

---

### Get Paginated Tasks

`GET /api/tasks/paginated`

| Parameter | Default | Description                  |
|-----------|---------|------------------------------|
| `page`    | `0`     | Page number (0-indexed)      |
| `size`    | `10`    | Number of tasks per page     |
| `sortBy`  | `id`    | Field to sort by             |

**Example:** `GET /api/tasks/paginated?page=0&size=5&sortBy=priority`

---

## Error Responses

All errors return a consistent JSON structure:

```json
{
  "timestamp": "2026-04-30T21:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Task with ID 999 not found",
  "path": "/api/tasks/999"
}
```

| Status | Meaning                              |
|--------|--------------------------------------|
| `400`  | Validation failed or bad input       |
| `404`  | Task not found                       |
| `500`  | Unexpected server error              |

---

## Health Endpoint

`GET /actuator/health`

```json
{
  "status": "UP"
}
```

Other available endpoints:
- `/actuator/info`
- `/actuator/metrics`
---

## Task Fields

| Field         | Type     | Rules                              |
|---------------|----------|------------------------------------|
| `title`       | String   | Required, 3–100 characters         |
| `description` | String   | Optional, max 500 characters       |
| `completed`   | Boolean  | `true` or `false`                  |
| `priority`    | String   | `LOW`, `MEDIUM`, `HIGH`            |
| `createdAt`   | DateTime | Auto-set on creation               |
| `updatedAt`   | DateTime | Auto-updated on every save         |

---

## Video

[https://www.youtube.com/watch?v=5SOGQC2BggU](https://www.youtube.com/watch?v=5SOGQC2BggU)