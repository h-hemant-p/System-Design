## 📘 What is a Class Diagram?

A **Class Diagram** is a **static UML (Unified Modeling Language)** diagram that models the **structure** of a software system by showing:

- **Classes**: Entities with attributes and operations.
- **Attributes**: Properties/data of a class.
- **Operations**: Behavior/functions of a class.
- **Relationships**: Connections between classes (e.g., inheritance, association).

#### 🔒 Access Modifiers

| Modifier  | Symbol | Meaning                            |
| --------- | ------ | ---------------------------------- |
| Public    | `+`  | Accessible from anywhere           |
| Private   | `-`  | Accessible only within class       |
| Protected | `#`  | Accessible within class & subclass |
| Package   | `~`  | Accessible within same package     |

#### 🧱 Class Structure

A class is shown as a rectangle with three compartments:

1. **Class Name**
2. **Attributes**
3. **Operations**

**Example:**

```
+-----------------------+
|       Customer        |
+-----------------------+
| -name: String         |
| -email: String        |
+-----------------------+
| +placeOrder(): void   |
+-----------------------+
```

#### 📌 Attributes Syntax

```
[visibility] attributeName: Type [multiplicity] [= defaultValue]
```

**Examples:**

- `-balance: Double = 0.0`
- `+email: String [1]`

#### 🔁 Operations Syntax

```
[visibility] methodName(param: Type): ReturnType
```

**Examples:**

- `+getName(): String`
- `+setEmail(email: String): void`

#### 🔗 Relationships in Class Diagrams

| Relationship    | Symbol                     | Description                                 |
| --------------- | -------------------------- | ------------------------------------------- |
| Association     | `------`                 | General connection between classes          |
| Directed Assoc. | `----➜`                 | One-way navigation                          |
| Inheritance     | `--▷` (hollow triangle) | Subclass "is-a" Superclass                  |
| Aggregation     | `◇---`                  | Weak "has-a", parts can exist independently |
| Composition     | `◆---`                  | Strong "has-a", parts depend on the whole   |
| Dependency      | `- - - >` (dashed)       | Temporary usage or reference                |
| Realization     | `--▷` (dashed)          | Implements interface                        |

### 🔍 Types of Association (In Detail)

##### 1. **Simple Association**

```
Customer -------- Order
```

##### 2. **Directed Association**

```
Customer ----➜ Order
```

##### 3. **Bidirectional Association**

```
Customer <----> Order
```

##### 4. **Aggregation**

```
Library ◇--- Book
```

##### 5. **Composition**

```
House ◆--- Room
```

##### 6. **Self Association**

```
Employee mentors Employee
```

##### 7. **Qualified Association**

```
Order [orderID] ---- OrderItem
```

##### 8. **Association Class**

```
Student ----- Enrollment ----- Course
           \               /
            \             /
              [date, grade]
```

##### 9. **Reflexive Association**

```
Person
  ▲   ▲
parent child
```

---

## 🧩 Interfaces & Abstract Classes

### 🔹 Interface

```
<<interface>> Payable
+pay(): void

Employee --▷ Payable
```

### 🔹 Abstract Class

```
<<abstract>> Animal
+makeSound(): void
```

---

## 🔢 Multiplicity Notations

| Notation | Meaning      |
| -------- | ------------ |
| `1`    | Exactly one  |
| `0..1` | Zero or one  |
| `0..*` | Zero or more |
| `1..*` | One or more  |

---

## 🧭 Steps to Create a Class Diagram

1. **Identify Classes** – Based on real-world entities.
2. **Add Attributes & Operations** – With types and visibility.
3. **Draw Relationships** – Use association, inheritance, etc.
4. **Define Multiplicities** – Like `1`, `0..*`.
5. **Use Stereotypes/Interfaces** – e.g., `<<interface>>`, `<<abstract>>`.
6. **Add Notes/Constraints** – Optional, for clarity.
7. **Review with Stakeholders** – Validate correctness.

---

## 🖼️ Example Class Diagram – Online Shopping System

```
+-----------------+        1       +----------------+
|    Customer     |----------------|     Order      |
+-----------------+                +----------------+
| -name: String   |                | -orderId: Int  |
| -email: String  |                | -date: Date    |
+-----------------+                +----------------+
| +placeOrder()   |        *       | +addItem()     |
+-----------------+                +----------------+
        |                                   |
        ▼                                   ▼
+----------------+                +------------------+
|    Account     |                |   OrderItem      |
+----------------+                +------------------+
| -password: str |                | -quantity: Int   |
+----------------+                +------------------+
                                     |
                                     ▼
                             +------------------+
                             |    Product       |
                             +------------------+
                             | -name: String    |
                             | -price: Double   |
                             +------------------+
```

---

## 🧩 Key UML Symbols Summary

| Symbol            | Meaning                       |
| ----------------- | ----------------------------- |
| `+`             | Public                        |
| `-`             | Private                       |
| `#`             | Protected                     |
| `~`             | Package                       |
| `--`            | Association                   |
| `--➜`          | Directed Association          |
| `--▷`          | Inheritance (hollow triangle) |
| `◇--`          | Aggregation                   |
| `◆--`          | Composition                   |
| `- - - >`       | Dependency (dashed)           |
| `<<interface>>` | Interface                     |
| `<<abstract>>`  | Abstract Class                |
