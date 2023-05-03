# Site to create a training plan and track results
# finalsurge
https://log.finalsurge.com/login.cshtml

# How to run:

mvn clean test

# Allure report

mvn allure:report

# How to view the report
- open page in browser:
 finalsurge\target\site\allure-maven-plugin\index.html
- mvn allure:serve
# Libraries used

- selenide
- selenide-testng
- testng
- log4j-api
- log4j-core
- slf4j-reload4j
- allure-testng
- allure-selenide
- allure-java-commons
- allure-maven
- maven-surefire-plugin
- aspectjweaver