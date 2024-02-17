## Automation Framework For Android Mobile App using Appium

### About
- This project aims to automate Testcases for Android Mobile App using Appium
- Link for Screenrecord succesfull running: https://screenrec.com/share/h5FW7Mutrb

### Tools Used
- This Framework has been built using Native appium with:
  - Java
  - TestNG
  - Apache Maven
  - Android Studio
  - appium inspector


  ### Installation
  - JDK 21 :https://www.oracle.com/java/technologies/downloads/#jdk21-windows
  - Intelij IDEA Commuity Edition: https://www.jetbrains.com/idea/
  - Git: https://git-scm.com/downloads
  - Apache Maven "Binary Zip" :https://maven.apache.org/download.cgi
  - Android Studio:https://developer.android.com/studio

  ### Framework Structure
   This Framework is designed using POM design pattern "Page Object Model",
  which is classified into:
  - ### pages package
    Where it conains page object classes for each page, that have locators and logic implementations for each page
  - ###  Test Package :
     Where it contains the tests writtten for the fllowing bussiness flow:
     1. Changing Temperature unit from C to F, along with proper assertions on main Weather
        screen
     2. Changing Time format from 24 to 12, along with proper assertions on main Weather screen.
     3. Assertion that Chance of rain (raining icon) and Humidity (waterdrop icon) values are
        displayed for each hour in the next 6 hours.

   ### How to Run Scenarios:
   -  Clone the project using "git clone 'url of the project'.
   -  configure your appium settings on your machine 'npm -g install appium'
   -  Setup Emulator device from Android studo
   - for a single Test scenario you can run it directly from InteliJ by right- Click on any test class and run it directly   .
   
