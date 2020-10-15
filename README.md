# UI Tests 
(Selenide, Java, TestNG)

## Install
First of all you need to install Maven, Git and Java (13)
https://maven.apache.org/install.html
Open project in IntelliJ Idea as a Maven project and Install "lombok" plugin.


## Run regression tests
```
mvn test -PRegression
```
## Run test separately
```
mvn test -Dtest=TestsName test

## Run test locally
```
Clone the project, right click on testng.xml file and chose "Run" (all tests on all environments will be run.)
You can choose one environment separately (change it in DriverBase, instead "browserName" get "chrome" or "firefox").

Screenshots are saved on test-result/reports folder in the project.