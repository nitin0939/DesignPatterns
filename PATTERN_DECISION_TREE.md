# How to Master Design Patterns (Not Just Memorize Them)

This is one of the biggest challenges developers face. The mistake most
people make is trying to **memorize 23 GoF design patterns**. Senior
engineers don't think that way.

Instead, they recognize **the problem first**, then the pattern naturally
appears.

Here's the technique that many experienced architects use.

---

# Step 1: Don't learn patterns. Learn the problems.

Instead of

> "I should use Factory."

Think

> "What problem do I have?"

For example

| Problem                                | Pattern            |
| --------------------------------------- | ------------------ |
| Object creation is complicated         | Factory            |
| Behavior changes at runtime            | Strategy           |
| Need notifications to multiple objects | Observer           |
| Too many constructor parameters        | Builder            |
| Need to wrap existing functionality    | Decorator          |
| Existing interface is incompatible     | Adapter            |
| Only one instance should exist         | Singleton (rarely) |
| One object controls many subsystems    | Facade             |
| Need undo/history                      | Command            |
| Objects should share common state      | Flyweight          |
| Copying an existing object beats rebuilding it | Prototype   |
| A single item and a group of items must act alike | Composite |
| Need to loop without exposing internal storage | Iterator    |
| Objects call each other in a tangled web | Mediator          |
| Need undo without exposing internals   | Memento             |
| Need a new operation across a whole hierarchy | Visitor      |
| Evaluating a small custom expression language | Interpreter  |

Patterns are simply **solutions to recurring problems.**

---

# Step 2: Ask yourself these questions

Whenever you're writing code, ask these questions.

## Question 1 — Am I creating too many objects?

Example

```java
if(type.equals("PDF"))
    return new PdfReport();

if(type.equals("CSV"))
    return new CsvReport();

if(type.equals("EXCEL"))
    return new ExcelReport();
```

You should think

> "Object creation is getting messy."

Pattern? ✅ **Factory**

---

## Question 2 — Can behavior change?

Example: Payment methods — Credit Card, UPI, Wallet, Net Banking.

Don't write

```java
if (type == "UPI") { ... }
if (type == "CARD") { ... }
if (type == "WALLET") { ... }
```

Ask

> "Can I replace the algorithm?"

Pattern? ✅ **Strategy**

---

## Question 3 — Can new features be added without changing old code?

Example: Coffee, Coffee + Milk, Coffee + Sugar, Coffee + Cream,
Coffee + Milk + Sugar...

If subclasses explode — `MilkCoffee`, `SugarCoffee`, `CreamCoffee`,
`MilkSugarCoffee`, `MilkCreamCoffee`...

Pattern? ✅ **Decorator**

---

## Question 4 — Am I notifying multiple objects?

Example: order placed, and you need Email, SMS, Analytics, Inventory,
Notification, Loyalty Points to all react.

Instead of

```java
email.send();
sms.send();
inventory.update();
analytics.log();
```

Think

> "Many listeners."

Pattern? ✅ **Observer**

---

## Question 5 — Is the constructor huge?

```java
Employee e = new Employee(
    id, name, address, salary, phone, email,
    manager, department, designation, joiningDate, ...
);
```

Pattern? ✅ **Builder**

---

## Question 6 — Does one class know too much?

Suppose `OrderService` calls into Inventory, Payment, Shipping, Invoice,
Email, SMS directly.

Maybe create an `OrderFacade` instead.

Pattern? ✅ **Facade**

---

## Question 7 — Is building this from scratch slower than copying one I already have?

Example: a game character with a fully-configured loadout, or a document
built from a heavily-customized template.

```java
Robot tank = new Robot("Tank", heavyArmor, weaponsLoadout);
Robot tankCopy = tank.clone(); // instead of rebuilding all that setup again
tankCopy.setName("Tank Copy");
```

Think

> "I already have one of these built — can I just copy it?"

Pattern? ✅ **Prototype**

---

## Question 8 — Do I need to treat one item and a group of items the same way?

Example: a file system, where a `File` and a `Folder` (which itself
contains files and folders) both need a `size()`.

```java
interface FileSystemNode { long size(); }

class File implements FileSystemNode { ... }

class Folder implements FileSystemNode {
    List<FileSystemNode> children;
    public long size() {
        return children.stream().mapToLong(FileSystemNode::size).sum();
    }
}
```

Think

> "This is a tree — leaves and branches should share one interface."

Pattern? ✅ **Composite**

---

## Question 9 — Do I need to loop over a collection without knowing how it's stored?

Example

```java
for (Item item : cart) {
    process(item);
}
```

This loop shouldn't care whether `cart` is backed by an array, a linked
list, or a database cursor.

Think

> "The caller shouldn't know or care what's underneath this collection."

Pattern? ✅ **Iterator**

---

## Question 10 — Are objects calling each other directly, and the web of connections is getting hard to follow?

Example: a chat room, where every `User` would otherwise need a direct
reference to every other `User` just to send a message.

```java
// instead of user1.notify(user2), user1.notify(user3), ...
chatRoom.sendMessage(user1, "hello");
```

Think

> "These objects shouldn't know about each other — only about one
> coordinator."

Pattern? ✅ **Mediator**

---

## Question 11 — Do I need to undo a change without exposing the object's private internals?

Example: a text editor's undo button, or rewinding a game character to a
checkpoint.

```java
EditorState snapshot = editor.save();
// ...user keeps typing...
editor.restore(snapshot); // back to the checkpoint
```

Think

> "I need a rollback point, but I shouldn't have to expose everything just
> to save it."

Pattern? ✅ **Memento**

---

## Question 12 — Do I keep adding new operations, not new types, across a whole class hierarchy?

Example: a `Shape` hierarchy (`Circle`, `Square`, `Triangle`) that now needs
`exportToSvg()`, and next month `calculateArea()`, and after that
`printSummary()` — each one touching every shape class if added as a method.

```java
shape.accept(new SvgExportVisitor());
shape.accept(new AreaCalculatorVisitor());
```

Think

> "I keep adding operations, not shapes — pull the operation out instead."

Pattern? ✅ **Visitor**

---

## Question 13 — Am I evaluating expressions in a small custom language, not just calling a library?

Example: a discount-rule engine parsing something like
`"price > 100 AND category == 'electronics'"` and checking it against an order.

```java
Expression rule = RuleParser.parse("price > 100 AND category == 'electronics'");
boolean applies = rule.interpret(order);
```

Think

> "I'm building a mini-grammar, and each rule needs to evaluate itself."

Pattern? ✅ **Interpreter**

---

# Step 3: Learn the pattern families

Instead of remembering 23 patterns separately, group them by the question
each family answers.

## Creational — "How do I create objects?"
Factory · Abstract Factory · Builder · Prototype · Singleton

## Structural — "How do I organize classes?"
Adapter · Decorator · Facade · Composite · Bridge · Proxy · Flyweight

## Behavioral — "How do objects communicate?"
Strategy · Observer · Command · State · Template Method ·
Chain of Responsibility · Mediator · Iterator · Visitor · Memento · Interpreter

---

# Step 4: Build a mental checklist

Whenever you're coding, pause for 10 seconds and ask:

- Is object creation becoming difficult? → **Factory**
- Need multiple algorithms? → **Strategy**
- Need runtime behavior changes? → **State** or **Strategy**
- Need notifications? → **Observer**
- Need wrappers? → **Decorator**
- Need compatibility? → **Adapter**
- Need one entry point? → **Facade**
- Need many constructor parameters? → **Builder**
- Copying beats rebuilding from scratch? → **Prototype**
- A leaf and a whole branch need to act alike? → **Composite**
- Need to loop without exposing internal storage? → **Iterator**
- Objects are calling each other directly, in a tangled web? → **Mediator**
- Need undo without exposing internals? → **Memento**
- Adding operations, not types, to a hierarchy? → **Visitor**
- Evaluating a small custom grammar or rule syntax? → **Interpreter**

---

# Step 5: Learn from bad code

This is the fastest method. Write bad code first, then ask "what smells?"

- Huge if-else → **Strategy**
- Too many `new()` calls → **Factory**
- Too many subclasses → **Decorator**
- Constructor with 20 arguments → **Builder**
- Copy-pasted setup code every time you need "one more like this" → **Prototype**
- Special-casing "is this one item or a whole group?" everywhere → **Composite**
- A getter added just so another class can walk your internal storage → **Iterator**
- A getter added just so another class can snapshot your state for later → **Memento**
- Every object holding direct references to five other objects → **Mediator**
- A new method added to every class in a hierarchy, every single time → **Visitor**

Eventually, you'll start recognizing patterns from the code smells
themselves, without needing to consciously run through a checklist.

---

# Step 6: Learn the SOLID principles first

Design patterns are built on top of SOLID.

| SOLID Principle       | Common Patterns                      |
| ---------------------- | ------------------------------------- |
| Single Responsibility | Facade, Decorator                    |
| Open/Closed            | Strategy, Decorator, Template Method, Visitor |
| Liskov Substitution    | Strategy, State                      |
| Interface Segregation | Adapter, Bridge                      |
| Dependency Inversion   | Factory, Abstract Factory            |

If you understand SOLID well, choosing patterns becomes much easier.

---

# Step 7: Practice with real systems

Map patterns to real-world scenarios you already use:

| Scenario                                              | Pattern                  |
| ------------------------------------------------------ | ------------------------- |
| Multiple payment gateways (Razorpay, Stripe, PayPal)  | Strategy                 |
| Spring Bean creation                                  | Factory                  |
| Spring AOP (`@Transactional`, `@Cacheable`)           | Proxy                    |
| SLF4J logging wrappers                                | Facade                   |
| Kafka event consumers notifying multiple services     | Observer (event-driven)  |
| `RestTemplateBuilder` or `WebClient.Builder`          | Builder                  |
| Java `Collections.unmodifiableList()`                 | Decorator                |
| Spring Security filter chain                          | Chain of Responsibility  |
| `JdbcTemplate`                                        | Template Method          |
| `Object.clone()` / `Cloneable`                        | Prototype                |
| Rendering nested folders and files in a file explorer | Composite                |
| Iterating a Java `Collection` or a JDBC `ResultSet`   | Iterator                 |
| A central event bus decoupling senders from listeners | Mediator                 |
| Ctrl+Z in any editor or IDE                            | Memento                  |
| Compiler/parser AST visitors (e.g. in ANTLR, javac)   | Visitor                  |
| Spring Expression Language (SpEL), regex engines      | Interpreter              |

Recognizing these examples in frameworks you already use makes the
patterns much easier to remember.

---

# A practical decision tree

When you're designing a class or feature, use this sequence:

1. **Is object creation becoming complex?** → Factory / Builder
2. **Do I have many `if-else` or `switch` statements based on type?** → Strategy or State
3. **Am I adding features by creating many subclasses?** → Decorator
4. **Do I need to notify multiple independent components?** → Observer
5. **Do I need to integrate an incompatible API?** → Adapter
6. **Do I want to simplify interactions with several subsystems?** → Facade
7. **Do I need to intercept or add behavior transparently?** → Proxy
8. **Am I executing a sequence of handlers?** → Chain of Responsibility
9. **Would copying an existing object be easier than building one from scratch?** → Prototype
10. **Should a single item and a whole group of items be treated identically?** → Composite
11. **Do I need to walk a collection without exposing how it's stored?** → Iterator
12. **Are objects calling each other directly in a tangled web?** → Mediator
13. **Do I need undo/rollback without exposing an object's internals?** → Memento
14. **Am I adding a new operation across a whole class hierarchy?** → Visitor
15. **Am I evaluating sentences in a small custom grammar?** → Interpreter

---

# How to truly master design patterns

Reading about patterns isn't enough. A highly effective progression is:

1. Learn the intent of one pattern.
2. Implement it from scratch in Java.
3. Refactor an existing project to use it.
4. Find where Spring, JDK, or Hibernate uses it.
5. Solve 3–5 practical problems with that pattern before moving to the next one.

After enough repetition, you'll stop asking *"Which pattern should I use?"*
and start recognizing *"I've seen this problem before — that pattern fits
here."* That's the transition from memorizing design patterns to thinking
like a software designer.

---

## This repo as practice material

Every pattern named above is implemented in this repo — see the
[main README](README.md) for the full list linking to each pattern's
package, README, and runnable example.
