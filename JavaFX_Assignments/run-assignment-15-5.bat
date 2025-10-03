@echo off
REM Set Java 21 and Maven environment
set JAVA_HOME=%USERPROFILE%\.jdk\jdk-21.0.4+7
set PATH=%JAVA_HOME%\bin;%USERPROFILE%\.maven\apache-maven-3.9.9\bin;%PATH%

echo Running Assignment 15.5: Change Color Using Mouse
echo.
java -cp "target\classes" --module-path "%USERPROFILE%\.m2\repository\org\openjfx\javafx-controls\21.0.4\javafx-controls-21.0.4.jar;%USERPROFILE%\.m2\repository\org\openjfx\javafx-base\21.0.4\javafx-base-21.0.4.jar;%USERPROFILE%\.m2\repository\org\openjfx\javafx-graphics\21.0.4\javafx-graphics-21.0.4.jar;%USERPROFILE%\.m2\repository\org\openjfx\javafx-fxml\21.0.4\javafx-fxml-21.0.4.jar" --add-modules javafx.controls,javafx.fxml -m javafx.assignments/com.example.asignment_15_5