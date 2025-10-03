@echo off
REM Set Java 21 and Maven environment
set JAVA_HOME=%USERPROFILE%\.jdk\jdk-21.0.4+7
set PATH=%JAVA_HOME%\bin;%USERPROFILE%\.maven\apache-maven-3.9.9\bin;%PATH%

echo Java version:
java -version
echo.
echo Maven version:
mvn -version
echo.
echo Running JavaFX application...
mvn javafx:run