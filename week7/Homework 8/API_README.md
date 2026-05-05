# Campus Task Board API Documentation

## Base URL
http://localhost:8080/api

## Endpoints

### Get All Tasks
GET /api/tasks

**Response 200 OK:**
```json
[
  {
    "id": 1,
    "title": "Study for exam",
    "description": "Review chapters 1-5",
    "completed": false,
    "priority": "HIGH"
  }
]
```

### Get Task by ID
GET /api/tasks/{id}

**Response 200 OK:**
```json
{
  "id": 1,
  "title": "Study for exam",
  "description": "Review chapters 1-5",
  "completed": false,
  "priority": "HIGH"
}
```

### Create Task
POST /api/tasks

**Request Body:**
```json
{
  "title": "Study for exam",
  "description": "Review chapters 1-5",
  "completed": false,
  "priority": "HIGH"
}
```

**Response 201 Created:**
```json
{
  "id": 1,
  "title": "Study for exam",
  "description": "Review chapters 1-5",
  "completed": false,
  "priority": "HIGH"
}
```

### Update Task
PUT /api/tasks/{id}

**Request Body:**
```json
{
  "title": "Study for exam",
  "description": "Review chapters 1-5",
  "completed": true,
  "priority": "HIGH"
}
```

**Response 200 OK:**
```json
{
  "id": 1,
  "title": "Study for exam",
  "description": "Review chapters 1-5",
  "completed": true,
  "priority": "HIGH"
}
```

### Delete Task
DELETE /api/tasks/{id}

**Response 204 No Content**

## Error Responses

### 400 Bad Request
```json
{ "timestamp": "2025-01-01T00:00:00", "status": 400, "error": "Bad Request", "message": "Title is required" }
```

### 404 Not Found
```json
{ "timestamp": "2025-01-01T00:00:00", "status": 404, "error": "Not Found", "message": "Task not found with id: 1" }
```