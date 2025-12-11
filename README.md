# Student Grade Management System

A simple console-based Java application to manage student records, calculate grades, and store data using file handling.  
The project uses Maven for build automation and Git for version control.

## Features
- Add new student records  
- View all students  
- Update an existing record  
- Delete a record  
- Automatic grade calculation based on marks  
- Data persistence using a `records.txt` file  
- Packaged as an executable JAR using Maven  

## Grade Calculation Logic
- **A** : 90–100  
- **B** : 80–89  
- **C** : 70–79  
- **D** : 60–69  
- **F** : Below 60  

## Project Structure
```
StudentGradeManager/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── student/
│                   ├── Student.java
│                   ├── GradeManager.java
│                   └── Main.java
├── records.txt
├── pom.xml
└── README.md
```

## Requirements
- Java JDK 17 or above  
- Apache Maven  
- Git (optional)

## How to Run

### 1. Build the project
```
mvn clean package
```

### 2. Run the JAR file
```
java -jar target/StudentGradeManager-1.0-SNAPSHOT.jar
```

## File Storage
All student data is stored in `records.txt`

## Version Control (Git)
```
git init
git add .
git commit -m "Initial commit"
```
