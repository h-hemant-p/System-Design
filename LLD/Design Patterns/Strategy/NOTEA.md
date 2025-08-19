The **Strategy Design Pattern** is a behavioral pattern that enables selecting an algorithm's behavior at runtime. It defines a family of algorithms, encapsulates each one, and makes them interchangeable. This pattern is useful when you want to avoid hardcoding algorithms and allow flexibility to switch between them.

### **Strategy Design Pattern**

#### **Key Concepts**

- **Intent**: Define a family of algorithms, encapsulate each one, and make them interchangeable. The strategy lets the algorithm vary independently from the clients that use it.
- **Components**:
  - **Context**: The class that uses a strategy and maintains a reference to a Strategy object.
  - **Strategy Interface**: Declares a common interface for all supported algorithms.
  - **Concrete Strategies**: Classes that implement the Strategy interface, providing specific algorithm implementations.
- **When to Use**:
  - When you have multiple algorithms for a specific task and want to switch between them dynamically.
  - When you want to avoid conditional statements (e.g., `if-else`) for selecting behavior.
  - When you need to isolate algorithm code from the client code.
- **Advantages**:
  - Promotes flexibility and reusability.
  - Simplifies unit testing (each strategy can be tested independently).
  - Reduces conditional logic in the client.
- **Disadvantages**:
  - Increases the number of classes.
  - Clients must be aware of different strategies to choose the appropriate one.
- **Real-World Examples**:
  - Sorting algorithms (e.g., QuickSort, MergeSort).
  - Payment processing (e.g., PayPal, CreditCard).
  - Compression algorithms (e.g., ZIP, RAR).

#### **Structure**

1. **Strategy Interface**: Defines a method that all concrete strategies implement.
2. **Concrete Strategies**: Implement the Strategy interface with specific behavior.
3. **Context**: Maintains a reference to a Strategy object and delegates the algorithm execution to it.

#### **UML Diagram (Simplified)**

```
+----------------+       +------------------+
|    Context     |<----->| Strategy         |
|                |       | + execute()      |
| - strategy     |       +------------------+
| + setStrategy()|            ^
| + execute()    |            |
+----------------+            |
                              |
       +----------------------+----------------------+
       |                      |                      |
+----------------+   +----------------+   +----------------+
| ConcreteStrategyA|   | ConcreteStrategyB|   | ConcreteStrategyC|
| + execute()     |   | + execute()     |   | + execute()     |
+----------------+   +----------------+   +----------------+
```

---

### **Java Implementation Example**

Here’s a Java example of the Strategy Pattern for a payment processing system.

#### **1. Strategy Interface**

```java
public interface PaymentStrategy {
    void pay(double amount);
}
```

#### **2. Concrete Strategies**

```java
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}
```

```java
public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal: " + email);
    }
}
```

#### **3. Context**

```java
public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    // Set the strategy dynamically
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Execute the strategy
    public void checkout(double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment method selected!");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}
```

#### **4. Client Code**

```java
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Pay with Credit Card
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        cart.checkout(100.50);

        // Pay with PayPal
        cart.setPaymentStrategy(new PayPalPayment("user@example.com"));
        cart.checkout(200.75);
    }
}
```

#### **Output**

```
Paid 100.5 using Credit Card: 1234-5678-9012-3456
Paid 200.75 using PayPal: user@example.com
```

---

### **Key Points in the Example**

- **Strategy Interface**: `PaymentStrategy` defines the `pay` method.
- **Concrete Strategies**: `CreditCardPayment` and `PayPalPayment` implement specific payment behaviors.
- **Context**: `ShoppingCart` holds a reference to a `PaymentStrategy` and delegates the payment task to it.
- **Dynamic Switching**: The client can switch strategies (e.g., CreditCard to PayPal) at runtime using `setPaymentStrategy`.

---

### **When to Use in Java**

- When you have multiple ways to perform a task (e.g., different sorting algorithms, payment methods, or compression techniques).
- When you want to decouple algorithm implementation from the client code.
- When you want to make algorithms easily extensible or replaceable.

---

### **Related Patterns**

- **Factory Pattern**: Often used to create strategy objects.
- **Command Pattern**: Both encapsulate actions, but Command focuses on encapsulating a request as an object, while Strategy focuses on interchangeable algorithms.
- **State Pattern**: Similar structure, but State changes behavior based on an object's internal state, while Strategy changes behavior based on client choice.

---

This implementation is concise and follows Java best practices. Let me know if you need further clarification or additional examples!
