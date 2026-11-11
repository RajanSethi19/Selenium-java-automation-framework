# Selenium Java Automation Framework

A UI test automation framework built from scratch with **Selenium WebDriver 4, Java 17, TestNG and Maven**, using the **Page Object Model (POM)** design pattern.

The practice application under test is [SauceDemo](https://www.saucedemo.com/) — a public demo e-commerce site made for automation practice. Its demo credentials are published on its own login page.

## What this framework demonstrates

- Page Object Model — one class per page, locators and page actions stay in the page class, tests stay readable
- A reusable `BasePage` with explicit waits (`WebDriverWait`) — no `Thread.sleep`
- `DriverFactory` with `ThreadLocal<WebDriver>` for safe parallel execution, using Selenium Manager (no manual driver downloads)
- Test data and settings kept out of the code in `config.properties`, with command-line override support
- Data-driven testing with TestNG `@DataProvider` (4 invalid-login combinations in one test method)
- Automatic screenshot capture on test failure
- TestNG suite file (`testng.xml`) grouping Login and Cart/Checkout tests
- GitHub Actions CI — tests run in headless Chrome on every push

## Project structure

```
selenium-java-automation-framework
├── pom.xml                                  -> dependencies: Selenium 4, TestNG
├── .github/workflows/maven.yml              -> GitHub Actions CI pipeline
└── src
    ├── main/java/com/rajansethi/qa
    │   ├── base
    │   │   └── BasePage.java                -> wait / click / type / getText helpers
    │   ├── pages
    │   │   ├── LoginPage.java
    │   │   ├── InventoryPage.java
    │   │   ├── CartPage.java
    │   │   └── CheckoutPage.java
    │   └── utils
    │       ├── DriverFactory.java           -> creates Chrome / Firefox / Edge
    │       ├── ConfigReader.java            -> reads config.properties
    │       └── ScreenshotUtil.java          -> screenshot on failure
    └── test
        ├── java/com/rajansethi/qa/tests
        │   ├── BaseTest.java                -> @BeforeMethod / @AfterMethod setup
        │   ├── LoginTest.java               -> valid login + data-driven invalid logins
        │   └── CartCheckoutTest.java        -> add to cart + end-to-end checkout
        └── resources
            ├── config.properties            -> baseUrl, browser, headless, credentials
            └── testng.xml                   -> suite definition
```

## Test coverage

| Test class | Test | What it verifies |
|---|---|---|
| LoginTest | validUserCanLogin | Valid user lands on the Products page |
| LoginTest | invalidLoginShowsError (x4 data sets) | Locked-out user, wrong password, empty username, empty password show the correct error |
| CartCheckoutTest | addProductToCart | 6 products listed, cart badge = 1, correct item in cart |
| CartCheckoutTest | completeCheckoutEndToEnd | Full purchase flow ends with "Thank you for your order!" |

## How to run

**Prerequisites:** Java 17+ and Maven installed, Chrome browser.

```bash
# Run the full suite (from the project folder)
mvn test

# Run headless (no visible browser window)
mvn test -Dheadless=true

# Run with a different browser
mvn test -Dbrowser=firefox
```

Or open the project in **IntelliJ IDEA** and run `testng.xml`, or any test class, directly.

Test data note: the name and postal code in `CartCheckoutTest` are dummy checkout data for the demo site, and the login credentials are SauceDemo's public demo credentials.

## Author

Rajan Sethi — QA Automation Engineer / SDET (Java, Selenium, TestNG, REST Assured, Playwright)
