# BookMyShow_Automation_Cognizant


📦 project-root
│
├── 📁 src
│   ├── 📁 main
│   │   ├── 📁 java
│   │   │   ├── 📁 base                  # Base setup classes
│   │   │   │   ├── ConfigLoader.java
│   │   │   │   └── DriverSetup.java
│   │   │   │
│   │   │   ├── 📁 constants             # Framework constants
│   │   │   │   └── FrameworkConstants.java
│   │   │   │
│   │   │   ├── 📁 locators              # Object repository handler
│   │   │   │   └── LocatorRepository.java
│   │   │   │
│   │   │   ├── 📁 pages                 # Page Object Model (POM) classes
│   │   │   │   ├── CityPage.java
│   │   │   │   ├── GiftCardPage.java
│   │   │   │   ├── LoginPage.java
│   │   │   │   └── MoviePage.java
│   │   │   │
│   │   │   ├── 📁 reports               # Report generation & listeners
│   │   │   │   ├── ExtentManager.java
│   │   │   │   └── ExtentTestNGListener.java
│   │   │   │
│   │   │   └── 📁 utils                 # Utility classes
│   │   │       ├── ExcelUtils.java
│   │   │       ├── LocatorReader.java
│   │   │       ├── ScreenshotUtil.java
│   │   │       └── WaitUtils.java
│   │   │
│   │   └── 📁 resources                 # Configuration and locator files
│   │       ├── config.properties
│   │       └── locator.properties
│   │
│   └── 📁 test
│       ├── 📁 java
│       │   ├── 📁 runners               # Test suite runner

│       │   │   └── TestSuiteRunner.java
│       │   │
│       │   └── 📁 tests                 # Test classes
│       │       ├── CityTest.java
│       │       ├── GiftCardTest.java
│       │       ├── LoginTest.java
│       │       ├── MovieTest.java
│       │       └── qeaBMS.java
│       │
│       └── 📁 resources                 # Test resource files (if any)
│
├── 📁 test-output                      # TestNG generated reports
│
├── 📄 pom.xml                          # Maven project file
├── 📄 testng.xml                       # TestNG suite configuration


