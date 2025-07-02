# 📘 What is a Sequence Diagram?

A **Sequence Diagram** is a type of UML (Unified Modeling Language) interaction diagram that shows how **objects interact in a particular scenario of a use case** by passing **messages** between each other **in time order**.

> ✅ It emphasizes **time-based interactions**, the **order of messages**, and **lifelines** of involved objects.



#### 🧩 Purpose of Sequence Diagrams

- Visualize the **order of interactions** between system components.
- Help in identifying **message flow**, **method invocations**, and **responses**.
- Useful for **dynamic modeling** of object behavior during runtime.
- Aid in designing system **logic**, **business processes**, and **method calls**.



#### 🧱 Basic Components of a Sequence Diagram

| Component                | Description                                                              |
| ------------------------ | ------------------------------------------------------------------------ |
| **Actor**          | External entity initiating the interaction (stick figure or named box).  |
| **Object**         | Instance of a class that participates in interaction.                    |
| **Lifeline**       | Vertical dashed line showing the object's existence during interaction.  |
| **Activation Box** | Thin rectangle showing the time a process or method is active/executing. |
| **Message**        | Communication between objects (solid/dashed arrows).                     |
| **Return Message** | Dashed line indicating response/result.                                  |
| **Destruction**    | An object being destroyed (`X` mark at end of lifeline).               |



#### 🔄 Message Types

| Type                 | Symbol                          | Description                           |
| -------------------- | ------------------------------- | ------------------------------------- |
| Synchronous Message  | Solid arrow (→)                | Caller waits for a response.          |
| Asynchronous Message | Solid arrow with open head (↝) | Caller does not wait.                 |
| Return Message       | Dashed arrow (↩)               | Result or acknowledgment from a call. |
| Self Message         | Arrow that loops back           | Object calls its own method.          |
| Create Message       | Arrow to new lifeline           | Creation of a new object.             |
| Destroy Message      | Cross (X)                       | Object is terminated at that point.   |



#### 🕒 Lifeline

- Represents the **existence** of an object over time.
- Drawn as a **dashed vertical line** from an object.
- Messages originate from and are sent to lifelines.



#### 🔲 Activation Box (Execution Specification)

- Rectangle on a lifeline showing **when an object is performing an action**.
- Appears during method execution or message handling.



#### 🔃 Control Structures (Fragments)

Used to model **conditional, looping, and parallel flows**. Represented with a frame:

| Fragment Type | Keyword      | Meaning                                  |
| ------------- | ------------ | ---------------------------------------- |
| Alternative   | `alt`      | If-else conditions                       |
| Option        | `opt`      | Optional behavior (if condition is true) |
| Loop          | `loop`     | Repetitive action                        |
| Break         | `break`    | Exit from interaction                    |
| Parallel      | `par`      | Parallel processing                      |
| Critical      | `critical` | Thread-safe (mutual exclusion)           |
| Negation      | `neg`      | Invalid or unwanted interaction          |



#### 🔖 Syntax (PlantUML-style example)

```
@startuml
actor User
participant LoginController
participant AuthService

User -> LoginController: enterCredentials()
LoginController -> AuthService: validateUser()
AuthService --> LoginController: success
LoginController --> User: showDashboard()
@enduml
```



#### 🖼️ Example: Online Login Sequence

```
Actor: User
Objects: LoginPage, AuthService, Database

User -> LoginPage: enterCredentials()
LoginPage -> AuthService: validateUser()
AuthService -> Database: fetchUserData()
Database --> AuthService: userData
AuthService --> LoginPage: validationResult
LoginPage --> User: loginSuccess
```



#### 🧭 Steps to Create a Sequence Diagram

1. **Identify Actors & Objects** – Define who initiates and participates.
2. **Draw Lifelines** – Represent objects across time.
3. **Add Messages** – Synchronous, asynchronous, returns, etc.
4. **Use Activation Boxes** – For processing/method durations.
5. **Model Control Logic** – Use `alt`, `loop`, `opt`, etc.
6. **Include Notes or Constraints** – To add comments or conditions.



#### 🎯 Use Cases

- Explaining the **logic behind a use case**.
- Designing **API request flows**.
- Modeling **inter-object communication** in OOP.
- Describing **multi-threaded or distributed systems**.




#### ⚠️ Limitations

- ❌ Becomes complex with many objects.
- ❌ Doesn't show class structure or attributes.
- ❌ Needs to be combined with class/activity diagrams for full picture.



#### 🔑 Summary Symbols

| Symbol / Element         | Meaning                             |
| ------------------------ | ----------------------------------- |
| `→`                   | Synchronous message                 |
| `↝`                   | Asynchronous message                |
| `↩`                   | Return message (dashed)             |
| `X`                    | Object destroyed                    |
| `[ ] alt/opt/loop/par` | Combined fragments for control flow |
| Rectangle on lifeline    | Activation box (execution)          |
| Dashed vertical line     | Object’s lifeline                  |


#### Example Diagram

```plaintext
User           LoginController       AuthService
 |----------------->|                      |
 | enterCredentials |                      |
 |                  |------------------->| |
 |                  | validateUser()     | |
 |                  |<-------------------| |
 |<-----------------| loginStatus        | |

```
