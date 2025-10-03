# JavaFX Maven Project

This project demonstrates how to use JavaFX with Maven.

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

## Project Structure

```
JavaFX_Assignments/
├── pom.xml                          # Maven configuration
├── src/
│   └── main/
│       ├── java/
│       │   ├── module-info.java     # Module descriptor
│       │   └── com/example/
│       │       └── App.java         # Main JavaFX application
│       └── resources/               # Resources directory
└── README.md                        # This file
```

## Building and Running

### Option 1: Using Maven JavaFX Plugin (Recommended)

To compile and run the application:
```bash
mvn clean javafx:run
```

### Option 2: Using Maven Exec Plugin

Add this to your pom.xml if you prefer using exec plugin:
```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>exec-maven-plugin</artifactId>
    <version>3.1.0</version>
    <configuration>
        <mainClass>com.example.App</mainClass>
    </configuration>
</plugin>
```

Then run:
```bash
mvn clean compile exec:java
```

### Option 3: Building JAR and Running

To build a JAR file:
```bash
mvn clean package
```

To run the JAR (note: this requires JavaFX runtime modules):
```bash
java --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml -cp target/javafx-assignments-1.0.0.jar com.example.App
```

## Features Included

- JavaFX Controls
- JavaFX FXML support
- JavaFX Web (optional)
- JavaFX Media (optional)
- Module system support
- Maven build configuration

## Development Tips

1. **IDE Setup**: Make sure your IDE supports JavaFX and Maven projects
2. **Java Version**: This project is configured for Java 11+
3. **JavaFX Version**: Currently using JavaFX 19.0.2.1 (can be updated in pom.xml)
4. **Module System**: The project uses the Java module system (module-info.java)

## Common Issues

1. **Module Path**: If you encounter module path issues, ensure JavaFX is properly configured
2. **Java Version**: Make sure you're using Java 11 or higher
3. **Platform Dependencies**: JavaFX dependencies are platform-specific and will be automatically resolved by Maven