# Event Management System (LLD)

This repository contains a **Low-Level Design (LLD)** implementation of an **Event Management System**, written in Java.  
The focus of this project is **object-oriented design, clarity of responsibilities, and extensibility**, rather than framework-heavy implementation.

---

## 📌 Problem Statement

Design an Event Management System where:
- Users can be added to the system
- Events can be created with limited capacity
- Users can register for events
- Overbooking is prevented
- Users can cancel registrations

---

## 🧠 Design Goals

- Clear separation of responsibilities
- Low coupling between domain objects
- Encapsulation of business rules
- Easy to extend for future requirements (waiting list, payments, notifications)
- Suitable for **LLD interview discussions**

---

## 🏗️ High-Level Design

### Core Classes

#### 1. `User`
Represents a user in the system.
- Immutable
- Identified uniquely by `userId`
- Contains basic user information

#### 2. `Event`
Represents an event.
- Has a fixed capacity
- Manages registered users internally
- Enforces business rules like capacity checks
- Stores only `userId` instead of `User` objects to reduce coupling

#### 3. `EventManager`
Acts as the service/orchestration layer.
- Manages users and events
- Coordinates registration and cancellation
- Delegates capacity enforcement to `Event`

#### 4. `EventApplication`
Bootstrap class for running the application (Spring Boot entry point).

---

---

## 🔄 Registration Flow

1. User is added to the system
2. Event is created with a defined capacity
3. User attempts to register
4. Event checks capacity internally
5. Registration succeeds or fails gracefully

Capacity exhaustion is treated as a **valid business outcome**, not an exception.

---

## ⚠️ Error Handling Strategy

- Invalid inputs (missing user/event) → exceptions
- Valid business constraints (event full) → boolean response

This distinction keeps business logic clean and expressive.

---

## 🧩 Extensibility (Future Enhancements)

This design can be easily extended to support:
- Waiting lists
- Registration timestamps
- Payment processing
- Notification system
- Persistence layer (database)
- REST APIs
- Thread-safe concurrency handling

---

## 🎯 LLD Interview Notes

- Designed using **Java**,
- Focus is on **domain modeling**, not infrastructure
- Spring Boot is used only for application bootstrapping
- Lombok is avoided/minimal to keep logic explicit

---

## 🚀 How to Run (Optional)

```bash
mvn clean spring-boot:run
