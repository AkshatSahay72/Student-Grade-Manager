package com.student;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GradeManager {

    private List<Student> students;
    private final String filePath;

    public GradeManager(String filePath) {
        this.filePath = filePath;
        this.students = new ArrayList<>();
        loadFromFile();
    }

    public void addStudent(String name, int marks) {
        String grade = calculateGrade(marks);
        Student student = new Student(name, marks, grade);
        students.add(student);
        System.out.println("Student added: " + student);
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- Student Records ---");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }

    public void updateStudent(int index, String newName, int newMarks) {
        if (index < 0 || index >= students.size()) {
            System.out.println("Invalid student index.");
            return;
        }

        Student s = students.get(index);
        s.setName(newName);
        s.setMarks(newMarks);
        s.setGrade(calculateGrade(newMarks));

        System.out.println("Student updated: " + s);
    }

    public void deleteStudent(int index) {
        if (index < 0 || index >= students.size()) {
            System.out.println("Invalid student index.");
            return;
        }

        Student removed = students.remove(index);
        System.out.println("Deleted student: " + removed);
    }

    private String calculateGrade(int marks) {
        if (marks >= 90 && marks <= 100) return "A";
        else if (marks >= 80) return "B";
        else if (marks >= 70) return "C";
        else if (marks >= 60) return "D";
        else return "F";
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Student s : students) {
                String line = s.getName() + "," + s.getMarks() + "," + s.getGrade();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Records saved to file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        if (!Files.exists(Paths.get(filePath))) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            students.clear();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 3) continue;

                String name = parts[0];
                int marks = Integer.parseInt(parts[1]);
                String grade = parts[2];

                students.add(new Student(name, marks, grade));
            }

            System.out.println("Loaded " + students.size() + " students from file.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }
}
