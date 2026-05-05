Here it is as one big copyable block:
# Campus Taskboard API

A RESTful task management API built with Spring Boot, Spring Data JPA, and H2. Features Spring Security, CORS configuration, API versioning, integration testing, and Swagger documentation.

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

| Field    | Value                     |
|----------|---------------------------|
| JDBC URL | `jdbc:h2:mem:taskboarddb` |
| Username | `sa`                      |
| Password | *(leave blank)*           |

---

## New Features (Homework 8)

### Spring Security
- Security filter chain configured with `@EnableWebSecurity`
- All task, H2 console, and actuator endpoints are publicly accessible
- CSRF disabled for REST API usage
- H2 console frame rendering enabled

### CORS Configuration
- Allowed origins: `http://localhost:3000`, `http://localhost:8080`
- Allowed methods: `GET`, `POST`, `PUT`, `DELETE`, `OPTIONS`
- Credentials supported

### API Versioning
- Versioned controller available at `/api/v1/tasks`
- Enables breaking changes without affecting existing clients
- Supports gradual migration and better API lifecycle management

### Integration Testing
- Tests written with `@SpringBootTest` and `MockMvc`
- Covers task creation, retrieval by ID, and 404 not found cases
- Database reset before each test with `@BeforeEach`

### API Documentation (Swagger UI)
- Auto-generated from code using SpringDoc OpenAPI
- Interactive testing directly in the browser
- Always up-to-date with code changes

Access at: `http://localhost:8080/swagger-ui.html`

### Custom Validation
- `@ValidPriority` annotation for priority field validation
- Custom `PriorityValidator` enforces `LOW`, `MEDIUM`, `HIGH` values

---

## Security Architecture

```
Request
    ↓
Security Filter Chain
    ↓
CORS Filter
    ↓
CSRF Filter (disabled)
    ↓
Authentication Filter
    ↓
Authorization Filter
    ↓
Controller
```

> **Note:** This is a basic security setup. In a production environment you would add JWT authentication, hashed passwords, role-based access control (RBAC), HTTPS, CSRF protection, rate limiting, and security headers.

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

Returns `400 Bad Request` if validation fails (e.g. missing title, invalid priority).

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

Sets `deleted = true`. The task is hidden from list endpoints but remains in the database.

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

| Parameter | Default | Description              |
|-----------|---------|--------------------------|
| `page`    | `0`     | Page number (0-indexed)  |
| `size`    | `10`    | Number of tasks per page |
| `sortBy`  | `id`    | Field to sort by         |

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

| Status | Meaning                        |
|--------|--------------------------------|
| `400`  | Validation failed or bad input |
| `404`  | Task not found                 |
| `500`  | Unexpected server error        |

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

| Field         | Type     | Rules                      |
|---------------|----------|----------------------------|
| `title`       | String   | Required, 3–100 characters |
| `description` | String   | Optional, max 500 chars    |
| `completed`   | Boolean  | `true` or `false`          |
| `priority`    | String   | `LOW`, `MEDIUM`, `HIGH`    |
| `createdAt`   | DateTime | Auto-set on creation       |
| `updatedAt`   | DateTime | Auto-updated on every save |

---

## Video

[https://www.youtube.com/watch?v=5SOGQC2BggU](https://www.youtube.com/watch?v=5SOGQC2BggU)