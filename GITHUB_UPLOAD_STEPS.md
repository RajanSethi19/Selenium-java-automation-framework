# How to run this project and put it on YOUR GitHub

## Step 1 — Run it on your laptop first (do not upload before this)
1. Unzip the project folder.
2. Open **IntelliJ IDEA** → File → Open → select the `selenium-java-automation-framework` folder.
3. Wait for Maven to download dependencies (first time takes a few minutes, internet needed).
4. Right-click `src/test/resources/testng.xml` → **Run**. Chrome will open and all tests will run on SauceDemo.
   - Or from terminal inside the project folder: `mvn test`
5. Green = pass. Now the project is genuinely yours — you have run it yourself.

## Step 2 — Understand it before any interviewer sees it
Read these 4 files in this order — this is what interviewers ask about:
1. `pom.xml` — which dependencies and versions, and why
2. `src/main/java/com/rajansethi/qa/pages/LoginPage.java` — what a Page Object is
3. `src/main/java/com/rajansethi/qa/utils/DriverFactory.java` — how the browser is created (ThreadLocal = parallel-safe)
4. `src/test/java/com/rajansethi/qa/tests/LoginTest.java` — @Test, @DataProvider, Assert

## Step 3 — Upload with GitHub Desktop (same steps you already know)
1. Go to github.com → **New repository** → name: `selenium-java-automation-framework` → Create (do NOT tick "Add README" — this project already has one).
2. Open **GitHub Desktop** → File → **Add Local Repository** → choose the unzipped project folder → "create a repository" if it asks.
3. You will see all files under Changes → Summary: `Initial commit - Selenium Java TestNG POM framework` → **Commit to main**.
4. Click **Publish repository** (or Push origin) → choose Public.
5. Refresh your GitHub profile — the project is live. Check the README looks good.

## Step 4 — Make the history look like real work (because it is)
Do NOT stop at one commit. As you learn, make small commits of your own, for example:
- Add a new test for sorting products A-Z
- Add a test for the checkout overview page total
- Update the README with what you changed

Real, small, regular commits by you = the strongest proof the work is yours.

## Step 5 — Put it on your resume / LinkedIn
Add under Projects:
**Selenium Java Automation Framework** — Selenium WebDriver 4, Java, TestNG, Maven, Page Object Model, GitHub Actions CI. Automated login, cart and end-to-end checkout flows for a demo e-commerce application, with data-driven tests and screenshots on failure. (GitHub link)
