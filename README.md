
# CIVIL ISSUE REPORTING Backend (Spring Boot + MongoDB + STOMP)

## Run (dev)
```bash
./gradlew bootRun
```
Set Mongo URI in `src/main/resources/application-dev.properties`.

## Build jar
```bash
./gradlew bootJar
```

## Environment (Render)
- `MONGO_URI` : your Atlas connection string
- `CORS_ORIGINS` : https://your-frontend,https://your-domain
- Render sets `PORT`

## REST
- POST /api/issues
- GET /api/issues
- GET /api/issues/{id}
- PATCH /api/issues/{id}/status
- PATCH /api/issues/{id}/assign?assignedTo=...&by=...&note=...
- POST /api/comments/{issueId}
- GET /api/comments/{issueId}

## WebSocket
- Endpoint: `/ws` (SockJS enabled)
- Topics:
  - `/topic/issues.created`
  - `/topic/issues.updated`
  - `/topic/comments.{issueId}`
```

