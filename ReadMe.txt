* General Rule of Thumb:
- src/main/java → Production code (application logic, reusable libraries, utilities).
- src/test/java → Test code (step definitions, hooks, test utilities, test data).

Here’s a clean way to organize:
bdd-selenium-picocontainer/
 ├── src/main/java/
 │    ├── pages/        # Page Objects
 │    └── utils/        # DriverFactory, ConfigReader
 ├── src/test/java/
 │    ├── stepdefinitions/
 │    ├── hooks/
 │    ├── helper/
 │    └── runners/
 ├── src/test/resources/
 │    └── testdata/     # JSON, CSV, Excel, properties


* src/main/java/ ->utils folder is meant for reusable helper classes that support your framework but are
not tied to a specific test scenario.

* Why not just use DriverFactory directly?
If you only ever needed a WebDriver, you could indeed call DriverFactory.getDriver() directly in your
step definitions. That works fine for small projects. But as soon as your framework grows, you’ll run
into problems:
- Tight coupling: Every step definition would be tied directly to DriverFactory. If you later add other
shared objects (API clients, DB connections, test data managers), you’d have to inject them separately
everywhere.
- No central context: Each class would manage its own driver reference, making it harder to share state
across steps in the same scenario.
- Harder to extend: Suppose you want to add logging, reporting, or scenario-specific data. Where do you
put it? If everything is tied to DriverFactory, you’ll end up with spaghetti code.

* Role of TestContext
TestContext acts as a container for all shared objects that a scenario needs. Think of it as a “backpack”
that Cucumber + PicoContainer hands to each step definition class.
- It owns the DriverFactory (and potentially other factories/utilities).
- It ensures that all step definitions in the same scenario share the same driver instance.
- It provides a single injection point: instead of injecting multiple dependencies into every step class,
you inject just TestContext.

*Allure Report
USe the command ' mvn allure:serve ' to view the local report after execution
