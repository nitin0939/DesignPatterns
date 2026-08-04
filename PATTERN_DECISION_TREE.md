# Which Pattern Is This? — A Field Key to the 23

Pick the branch that matches your symptom, then read down the numbered
questions until one fits — like a naturalist's identification key. The
first "yes" wins; if nothing fits, you may not need a pattern yet.

**The one question underneath every branch:** what varies in your design,
and what stays fixed? Name the thing that changes, and the pattern usually
follows.

> One caution before you reach for any of these: a pattern is a response to
> a pain you already have, not a template to apply in advance. If you can't
> point to the actual symptom — a growing conditional, a constructor with
> ten optional parameters, callbacks tangled three levels deep — hold off.
> Patterns you don't need yet add more structure than the problem does.

---

## 01 — Creational: the pain is in *how* something gets built

| # | If this is your symptom... | ...it's probably | What varies |
|---|---|---|---|
| 1 | Must there be exactly one instance of this class for the whole app, reachable from anywhere? | **Singleton** | How many instances may exist — capped at one, behind a single access point. |
| 2 | Is building one of these from scratch slow or fiddly, when copying an existing, already-configured one would be easier? | **Prototype** | Whether a new object is built with `new`, or copied from an existing instance via `clone()`. |
| 3 | Does this object need many optional parts assembled step by step — a single constructor would need a dozen parameters, half of them optional? | **Builder** | How construction is broken into steps, kept separate from what the finished object looks like. |
| 4 | Do several related objects need to be created together so they always match — every part "Chicago style", or every widget "dark theme"? | **Abstract Factory** | An entire family of related objects, produced together so they can never mismatch. |
| 5 | Should subclasses decide which concrete class gets created, while the surrounding steps stay exactly the same? | **Factory Method** | Which concrete class gets instantiated — decided by an overridden method, not the calling code. |

*Watch for:* Singleton overused becomes hidden global state. Reach for it
only when "more than one" would be a real bug, not just untidy.

---

## 02 — Structural: the pain is in how classes *compose*

| # | If this is your symptom... | ...it's probably | What varies |
|---|---|---|---|
| 1 | Do two pieces of code have incompatible interfaces that need to work together, without you touching either one? | **Adapter** | The shape of a call — translated from what the client sends to what the existing class expects. |
| 2 | Does one simple task require calls into many classes, in a specific order, and people keep getting the order wrong? | **Facade** | How much of a subsystem's complexity is exposed — collapsed behind one simple entry point. |
| 3 | Do you need to add responsibilities to one specific object, stackable in any combination, without subclassing every combination? | **Decorator** | What gets layered onto an object at runtime — each layer wraps and extends the one underneath. |
| 4 | Are you modeling a part-whole tree, where a single item and a whole group of items should be treated identically? | **Composite** | How deep the structure is — a leaf and a branch share one interface, so callers never check which. |
| 5 | Do you need to control, delay, or guard access to an object — because it's expensive, remote, or needs a permission check first? | **Proxy** | What happens before a real call reaches its target — a stand-in intercepts every call first. |
| 6 | Do you have two things that both vary independently — e.g. remote type × device type — where inheritance would multiply into a mess? | **Bridge** | Two dimensions of change, kept independent through composition instead of one tangled inheritance tree. |
| 7 | Are you creating huge numbers of similar objects and paying for the same duplicated data over and over? | **Flyweight** | How much state is shared versus unique per object — the shared part is built once and reused everywhere. |

---

## 03 — Behavioral: the pain is in how objects *talk*

| # | If this is your symptom... | ...it's probably | What varies |
|---|---|---|---|
| 1 | Do several objects need to be notified automatically whenever one object's state changes? | **Observer** | Who's listening — a subject holds a list of observers instead of hardcoding who gets told what. |
| 2 | Do you need to swap an algorithm or behavior at runtime, without touching the object that uses it? | **Strategy** | The algorithm itself — held as an object, swappable, instead of hardcoded or inherited. |
| 3 | Does an object's behavior change dramatically depending on its own internal state, and the conditionals keep multiplying? | **State** | Which behavior runs for a given method — delegated to a "current state" object instead of a flag. |
| 4 | Do you want to turn a request into an object, so it can be queued, logged, handed off, or undone? | **Command** | The request itself — represented as an object, decoupling who asks from who actually does it. |
| 5 | Do several classes share the same overall algorithm, differing only in a few specific steps? | **Template Method** | Individual steps of a fixed algorithm — subclasses override the steps, never the sequence. |
| 6 | Do you need to walk through a collection's items without exposing how that collection is actually stored? | **Iterator** | How traversal happens internally — array, list, tree — hidden behind one `hasNext()`/`next()` contract. |
| 7 | Should a request be offered to a series of handlers, one at a time, until one of them deals with it? | **Chain of Responsibility** | Which object actually handles a request — decided at runtime by passing it along a chain. |
| 8 | Is communication between a set of objects turning into a tangled many-to-many mess of direct references? | **Mediator** | Who talks to whom — routed through one central object instead of a web of direct connections. |
| 9 | Do you need to save and later restore an object's state — undo — without exposing its internals to do it? | **Memento** | Where a saved snapshot lives, and who's allowed to see inside it (only the object itself). |
| 10 | Do you need to add a new operation across a whole class hierarchy, without editing every class in it? | **Visitor** | The operation performed on a structure — pulled into its own object instead of a new method per class. |
| 11 | Are you evaluating sentences in a small, custom grammar or expression language? | **Interpreter** | How one grammar rule combines with another — each rule becomes a class that knows how to evaluate itself. |

*Watch for:*
- **Observer** — forgotten unsubscribes are a classic memory-leak source.
- **Visitor** — every new *element* type still means updating every existing
  visitor. It trades one kind of change for another.

---

## Full plate, for scanning

| Creational | Structural | Behavioral |
|---|---|---|
| Singleton | Adapter | Observer |
| Prototype | Facade | Strategy |
| Builder | Decorator | State |
| Abstract Factory | Composite | Command |
| Factory Method | Proxy | Template Method |
| | Bridge | Iterator |
| | Flyweight | Chain of Responsibility |
| | | Mediator |
| | | Memento |
| | | Visitor |
| | | Interpreter |

See each pattern's own README (linked from the [main README](README.md))
for a full implementation, participant table, and diagrams.
