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

# Every pattern, grouped by pattern

Everything above, pulled together by pattern — the exact same facts, just
gathered under one heading per pattern instead of split across Steps 1–7
and the decision tree. Some patterns have a full worked example; others
only got a line or two so far, and that's shown as-is rather than padded out.

## Creational

### Factory (Factory Method)
- **Symptom:** object creation is complicated.
- **Question:** Am I creating too many objects?
- **Example:** a type-based if/else chain building different report types (`PdfReport`, `CsvReport`, `ExcelReport`).
- **Checklist cue:** is object creation becoming difficult?
- **Code smell:** too many `new()` calls.
- **SOLID:** Dependency Inversion.
- **Real-world:** Spring Bean creation.
- **Decision-tree step:** #1 — is object creation becoming complex?

### Abstract Factory
- **SOLID:** Dependency Inversion (alongside Factory).
- *(Otherwise only appears in the pattern-family grouping — no dedicated example yet.)*

### Builder
- **Symptom:** too many constructor parameters.
- **Question:** Is the constructor huge?
- **Example:** an `Employee` constructor with ten-plus parameters.
- **Checklist cue:** need many constructor parameters?
- **Code smell:** constructor with 20 arguments.
- **Real-world:** `RestTemplateBuilder` / `WebClient.Builder`.
- **Decision-tree step:** #1 — shared with Factory.

### Prototype
- **Symptom:** copying an existing object beats rebuilding it.
- **Question:** Is building this from scratch slower than copying one I already have?
- **Example:** cloning a fully-configured game `Robot`.
- **Checklist cue:** copying beats rebuilding from scratch?
- **Code smell:** copy-pasted setup code every time you need "one more like this."
- **Real-world:** `Object.clone()` / `Cloneable`.
- **Decision-tree step:** #9.

### Singleton
- **Symptom:** only one instance should exist (rarely the right call).
- *(Otherwise only appears in the pattern-family grouping.)*

## Structural

### Adapter
- **Symptom:** existing interface is incompatible.
- **Checklist cue:** need compatibility?
- **SOLID:** Interface Segregation.
- **Decision-tree step:** #5 — integrating an incompatible API.
- *(No dedicated worked example yet.)*

### Bridge
- **SOLID:** Interface Segregation (alongside Adapter).
- *(Otherwise only appears in the pattern-family grouping.)*

### Composite
- **Symptom:** a single item and a group of items must act alike.
- **Question:** Do I need to treat one item and a group of items the same way?
- **Example:** a `File`/`Folder` tree where both need `size()`.
- **Checklist cue:** a leaf and a whole branch need to act alike?
- **Code smell:** special-casing "is this one item or a whole group?" everywhere.
- **Real-world:** rendering nested folders/files in a file explorer.
- **Decision-tree step:** #10.

### Decorator
- **Symptom:** need to wrap existing functionality.
- **Question:** Can new features be added without changing old code?
- **Example:** Coffee + Milk + Sugar combinations exploding into subclasses.
- **Checklist cue:** need wrappers?
- **Code smell:** too many subclasses.
- **SOLID:** Single Responsibility, Open/Closed.
- **Real-world:** `Collections.unmodifiableList()`.
- **Decision-tree step:** #3.

### Facade
- **Symptom:** one object controls many subsystems.
- **Question:** Does one class know too much?
- **Example:** `OrderService` calling Inventory/Payment/Shipping/Invoice/Email/SMS directly.
- **Checklist cue:** need one entry point?
- **SOLID:** Single Responsibility.
- **Real-world:** SLF4J logging wrappers.
- **Decision-tree step:** #6.

### Flyweight
- **Symptom:** objects should share common state.
- *(Otherwise only appears in the pattern-family grouping.)*

### Proxy
- **Real-world:** Spring AOP (`@Transactional`, `@Cacheable`).
- **Decision-tree step:** #7 — intercepting or adding behavior transparently.
- *(No dedicated symptom row or example yet.)*

## Behavioral

### Strategy
- **Symptom:** behavior changes at runtime.
- **Question:** Can behavior change?
- **Example:** payment-method if/else chains (Credit Card, UPI, Wallet, Net Banking).
- **Checklist cue:** need multiple algorithms? / need runtime behavior changes?
- **Code smell:** huge if-else.
- **SOLID:** Open/Closed, Liskov Substitution.
- **Real-world:** multiple payment gateways (Razorpay, Stripe, PayPal).
- **Decision-tree step:** #2 — shared with State.

### Observer
- **Symptom:** need notifications to multiple objects.
- **Question:** Am I notifying multiple objects?
- **Example:** order placed → Email, SMS, Analytics, Inventory all reacting.
- **Checklist cue:** need notifications?
- **Real-world:** Kafka event consumers notifying multiple services.
- **Decision-tree step:** #4.

### Command
- **Symptom:** need undo/history.
- *(Otherwise only appears in the pattern-family grouping.)*

### State
- **Checklist cue:** need runtime behavior changes? (alongside Strategy)
- **SOLID:** Liskov Substitution (alongside Strategy).
- **Decision-tree step:** #2 — shared with Strategy.
- *(No dedicated symptom row or example yet.)*

### Template Method
- **SOLID:** Open/Closed.
- **Real-world:** `JdbcTemplate`.
- *(Otherwise only appears in the pattern-family grouping.)*

### Chain of Responsibility
- **Real-world:** Spring Security filter chain.
- **Decision-tree step:** #8 — executing a sequence of handlers.
- *(No dedicated symptom row or example yet.)*

### Iterator
- **Symptom:** need to loop without exposing internal storage.
- **Question:** Do I need to loop over a collection without knowing how it's stored?
- **Example:** looping over a `cart` without knowing if it's an array, list, or DB cursor.
- **Checklist cue:** need to loop without exposing internal storage?
- **Code smell:** a getter added just so another class can walk your internal storage.
- **Real-world:** iterating a Java `Collection` or a JDBC `ResultSet`.
- **Decision-tree step:** #11.

### Mediator
- **Symptom:** objects call each other in a tangled web.
- **Question:** Are objects calling each other directly, and the web of connections is getting hard to follow?
- **Example:** a chat room routing messages instead of users holding direct references to each other.
- **Checklist cue:** objects calling each other directly, in a tangled web?
- **Code smell:** every object holding direct references to five other objects.
- **Real-world:** a central event bus decoupling senders from listeners.
- **Decision-tree step:** #12.

### Memento
- **Symptom:** need undo without exposing internals.
- **Question:** Do I need to undo a change without exposing the object's private internals?
- **Example:** saving/restoring an editor's state for undo.
- **Checklist cue:** need undo without exposing internals?
- **Code smell:** a getter added just so another class can snapshot your state for later.
- **Real-world:** Ctrl+Z in any editor or IDE.
- **Decision-tree step:** #13.

### Visitor
- **Symptom:** need a new operation across a whole hierarchy.
- **Question:** Do I keep adding new operations, not new types, across a whole class hierarchy?
- **Example:** adding `exportToSvg()`/`calculateArea()` across a `Shape` hierarchy without editing every class.
- **Checklist cue:** adding operations, not types, to a hierarchy?
- **Code smell:** a new method added to every class in a hierarchy, every single time.
- **SOLID:** Open/Closed.
- **Real-world:** compiler/parser AST visitors (ANTLR, javac).
- **Decision-tree step:** #14.

### Interpreter
- **Symptom:** evaluating a small custom expression language.
- **Question:** Am I evaluating expressions in a small custom language, not just calling a library?
- **Example:** a discount-rule engine parsing `"price > 100 AND category == 'electronics'"`.
- **Checklist cue:** evaluating a small custom grammar or rule syntax?
- **Real-world:** Spring Expression Language (SpEL), regex engines.
- **Decision-tree step:** #15.

---

## This repo as practice material

Every pattern named above is implemented in this repo — see the
[main README](README.md) for the full list linking to each pattern's
package, README, and runnable example.
