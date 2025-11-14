# Test Management Mini Framework

## Goal
A very simple Java framework to model test management concepts: TestCase, TestSuite, TestRun. Good for learning OOP basics and patterns (Singleton + Factory) before adding execution logic and real API calls.

## Core Classes
- `TestCase`: Represents one test with id, name, description.
- `TestSuite`: Holds a list of related test cases.
- `TestRun`: Groups suites under a run identifier (e.g., a CI build or daily run).
- `ConfigManager` (Singleton): One place for shared config like `baseUrl`.
- `TestCaseFactory` (Factory): Central method to create test cases (future validation hook).
- `ApiClient`: Placeholder wrapper for future REST Assured calls (create / get / update test cases).
- `TestDriver`: Basic demo that wires objects and prints them.

## Patterns Used
- Singleton: Ensures only one `ConfigManager` instance.
- Factory: Simplifies creation of `TestCase` objects and isolates construction logic.

## Current Output
`TestDriver` prints a `TestRun` object using `toString()` which cascades into `TestSuite` and `TestCase` lists.

## JSON Building 
Right now the code does NOT build JSON. It relies on Java's `toString()` which is: Human-readable



## Mock API Layer (CRUD)
Added a lightweight in-memory simulation of the required endpoints:

Endpoints represented logically:
- POST /testcases  -> `InMemoryTestCaseService.create(TestCase)` returns `201` or validation error.
- GET /testcases/{id} -> `get(int id)` returns `200` or `404`.
- PUT /testcases/{id} -> `update(int id, TestCase)` returns `200` or `404` / `400`.

Supporting classes:
- `ApiResponse<T>`: Wraps statusCode, body, message (simulates HTTP response).
- `TestCaseService`: Interface abstraction for CRUD (enables real HTTP client later).
- `InMemoryTestCaseService`: Map-backed implementation with validation (duplicate id, blank fields).
- `CrudDemoDriver`: Demonstrates and validates CRUD operations (prints status vs expected).

Sample output from `CrudDemoDriver` execution:
```
CREATE => status=201 expected=201 ok=true body=TestCase{id=1, name='Login Test', description='Verify login works'} message=Created
GET existing => status=200 expected=200 ok=true body=TestCase{id=1, name='Login Test', description='Verify login works'} message=OK
GET missing => status=404 expected=404 ok=true body=null message=Not Found
UPDATE => status=200 expected=200 ok=true body=TestCase{id=1, name='Login Test Updated', description='Updated description'} message=Updated
UPDATE missing => status=404 expected=404 ok=true body=null message=Cannot update missing TestCase
CREATE duplicate => status=409 expected=409 ok=true body=null message=TestCase with id already exists
CREATE invalid => status=400 expected=400 ok=true body=null message=Name/Description required
```
