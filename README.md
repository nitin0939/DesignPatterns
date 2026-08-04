# Design Patterns

Java implementations of all 23 Gang of Four design patterns, using examples
from *Head First Design Patterns* — the book's own canonical example where it
has one, and a clearly-labeled book-style invented example (reusing the
book's own domains, like Duck or Starbuzz Coffee) where it doesn't.

Not sure which pattern fits your problem? See
**[PATTERN_DECISION_TREE.md](PATTERN_DECISION_TREE.md)** — a symptom-first
field key that walks you to the right one.

Every pattern lives in its own package with:
- A runnable `Test*.java` client demonstrating it end to end
- Javadoc on every method
- A `*_README.md` with a participant table, self-explanatory Mermaid class +
  sequence diagrams, and a step-by-step call-flow trace

## Creational

| Pattern | Example | README |
|---|---|---|
| Factory Method | Pizza Store | [FactoryMethod_README.md](src/designpatterns/creational/factory/FactoryMethod_README.md) |
| Abstract Factory | Pizza Ingredient Factory | [AbstractFactory_README.md](src/designpatterns/creational/abstractfactory/AbstractFactory_README.md) |
| Builder | Starbuzz beverage order | [Builder_README.md](src/designpatterns/creational/builder/Builder_README.md) |
| Builder (fluent variant) | Starbuzz beverage order, chained setters | [FluentBuilder_README.md](src/designpatterns/creational/builder/fluent/FluentBuilder_README.md) |
| Prototype | Duck cloning | [Prototype_README.md](src/designpatterns/creational/prototype/Prototype_README.md) |
| Singleton | Chocolate Boiler (3 variants) | [Singleton_README.md](src/designpatterns/creational/singleton/Singleton_README.md) |

## Structural

| Pattern | Example | README |
|---|---|---|
| Adapter | Duck/Turkey Adapter | [Adapter_README.md](src/designpatterns/structural/adapter/Adapter_README.md) |
| Bridge | Universal Remote Control | [Bridge_README.md](src/designpatterns/structural/bridge/Bridge_README.md) |
| Composite | Diner Menu tree | [Composite_README.md](src/designpatterns/structural/composite/Composite_README.md) |
| Decorator | Starbuzz Coffee | [Decorator_README.md](src/designpatterns/structural/decorator/Decorator_README.md) |
| Facade | Home Theater | [Facade_README.md](src/designpatterns/structural/facade/Facade_README.md) |
| Flyweight | Forest of trees | [Flyweight_README.md](src/designpatterns/structural/flyweight/Flyweight_README.md) |
| Proxy | Virtual proxy for album covers | [Proxy_README.md](src/designpatterns/structural/proxy/Proxy_README.md) |

## Behavioral

| Pattern | Example | README |
|---|---|---|
| Chain of Responsibility | Support ticket escalation | [ChainOfResponsibility_README.md](src/designpatterns/behavioral/chainofresponsibility/ChainOfResponsibility_README.md) |
| Command | Remote Control | [Command_README.md](src/designpatterns/behavioral/command/Command_README.md) |
| Interpreter | Postfix (RPN) expression evaluator | [Interpreter_README.md](src/designpatterns/behavioral/interpreter/Interpreter_README.md) |
| Iterator | Pancake House / Diner menus | [Iterator_README.md](src/designpatterns/behavioral/iterator/Iterator_README.md) |
| Mediator | Smart Home Hub | [Mediator_README.md](src/designpatterns/behavioral/mediator/Mediator_README.md) |
| Memento | Text editor undo | [Memento_README.md](src/designpatterns/behavioral/memento/Memento_README.md) |
| Observer | Weather Station | [Observer_README.md](src/designpatterns/behavioral/observer/Observer_README.md) |
| State | Gumball Machine | [State_README.md](src/designpatterns/behavioral/state/State_README.md) |
| Strategy | Duck Simulator | [Strategy_README.md](src/designpatterns/behavioral/strategy/Strategy_README.md) |
| Template Method | Caffeine Beverage | [TemplateMethod_README.md](src/designpatterns/behavioral/templatemethod/TemplateMethod_README.md) |
| Visitor | Operations over the Diner Menu tree | [Visitor_README.md](src/designpatterns/behavioral/visitor/Visitor_README.md) |

## Running an example

Each pattern's package has a `Test*.java` class with a `main` method. From
the `src` directory:

```bash
javac -d out designpatterns/creational/factory/*.java
java -cp out designpatterns.creational.factory.TestFactoryMethod
```
