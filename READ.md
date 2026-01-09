University Management System
Project Description
This is a Java-based University Management System that demonstrates object-oriented programming principles including inheritance, polymorphism, abstraction, and interfaces. The system manages courses, professors, and university information with support for different course types (Math and Science).
Features
Course Management: Create and manage different types of courses (Math and Science)
Student Enrollment: Track enrolled students and check course availability
Professor Management: Manage professor information including tenure status and experience
University Information: Store and display university details including rankings
Course Sorting: Sort courses by credits
Course Search: Search courses by course code
Project Structure
src/
├── Main.java
├── printable/
│   └── Printable.java
├── models/
│   ├── Course.java
│   ├── Professor.java
│   └── University.java
└── courseTypes/
├── Math.java
└── Science.java
Class Descriptions
Interfaces
Printable: Interface for objects that can print their information
Models
Course (Abstract): Base class for all courses with common properties and methods
Professor (Final): Represents university professors with tenure tracking
University: Represents university entities with ranking system
Course Types
Math: Math courses with student capacity tracking
Science: Science courses with laboratory information and hours
Requirements Implemented
OOP Principles:
Inheritance:
Math and Science classes extend Course abstract class
Proper use of super() constructor calls
Polymorphism:
Abstract method isFull() implemented differently in Math and Science
printInfo() method overridden in subclasses
Abstraction:
Course is an abstract class with abstract method isFull()
Encapsulation:
Private fields with public getters
Protected fields in Course for subclass access
Interfaces:
Printable interface implemented by Course, Professor, and University
Additional Features
Method Overloading:
addStudent() and addStudent(int count) in Course
gainExperience() and gainExperience(int years) in Professor
improveRanking() and improveRanking(int positions) in University
equals() and hashCode():
Properly implemented in all model classes
Final Classes:
Professor class is marked as final
Final Methods:
printInfo() in University is marked as final
How to Run
Compile the project:
bash
javac Main.java
Run the program:
bash
java Main
Expected Output
The program will display:
University information
Search results for course by code
Sorted list of courses by credits
Available courses (not full)
Count of tenured professors
Sample Output
UNIVERSITY SYSTEM INFO
University → Stanford University, California, USA, Ranking #3, Students: 17000

Found: Chemistry (Code: CM)
Chemistry - 10 credits
Discrete Mathematics - 5 credits
Calculus - 12 credits
Discrete Mathematics has available seats.
Calculus has available seats.

COUNT TENURED PROFESSORS
Number of tenured professors: 1
Technologies Used
Java
Object-Oriented Programming
Collections Framework (ArrayList)
Author
Assignment 2 - OOP Course
License
This project is created for educational purposes.