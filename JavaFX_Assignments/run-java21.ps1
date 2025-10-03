# Set Java 21 and Maven environment
$env:JAVA_HOME = "$env:USERPROFILE\.jdk\jdk-21.0.4+7"
$env:PATH = "$env:JAVA_HOME\bin;$env:USERPROFILE\.maven\apache-maven-3.9.9\bin;$env:PATH"

Write-Host "Java version:" -ForegroundColor Green
java -version
Write-Host ""
Write-Host "Maven version:" -ForegroundColor Green
mvn -version
Write-Host ""
Write-Host "Running JavaFX application..." -ForegroundColor Green
mvn javafx:run