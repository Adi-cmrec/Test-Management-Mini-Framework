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