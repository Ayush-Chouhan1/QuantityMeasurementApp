# Quantity Measurement Backend

This repository contains the backend microservices under:

`microservice-architecture/`

## Services

- `eureka-server` on `8761`
- `security-service` on `8081`
- `quantity-measurement-app` on `8082`
- `api-gateway` on `8080`

Frontend should call the gateway (`http://localhost:8080`).

## Prerequisites

- Java 17+
- MySQL running on `localhost:3306`
- Database: `quantity_measurement_db`
- MySQL credentials in current config:
  - username: `root`
  - password: `root`

## Start All Backend Services

From `microservice-architecture/`:

```powershell
.\start-backend.ps1
```

This starts services in dependency order and writes logs to:

`microservice-architecture/run-logs/`

First run can take several minutes because Maven downloads dependencies.

## Stop All Backend Services

From `microservice-architecture/`:

```powershell
.\stop-backend.ps1
```
