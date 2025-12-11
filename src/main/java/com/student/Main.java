package com.student;

import java.util.Scanner;

public class Main {

    private static final String FILE_PATH = "records.txt";

    public static void main(String[] args) {
        GradeManager manager = new GradeManager(FILE_PATH);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.print("Enter choice: ");
            String input = scanner.nextLine();

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1:
                    addStudentFlow(manager, scanner);
                    break;
                case 2:
                    manager.listStudents();
                    break;
                case 3:
                    updateStudentFlow(manager, scanner);
                    break;
                case 4:
                    deleteStudentFlow(manager, scanner);
                    break;
                case 5:
                    manager.saveToFile();
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Student Grade Manager ===");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
    }

    private static void addStudentFlow(GradeManager manager, Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter marks: ");
        int marks = Integer.parseInt(scanner.nextLine());

        manager.addStudent(name, marks);
    }

    private static void updateStudentFlow(GradeManager manager, Scanner scanner) {
        manager.listStudents();
        System.out.print("Enter student number to update: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();

        System.out.print("Enter new marks: ");
        int newMarks = Integer.parseInt(scanner.nextLine());

        manager.updateStudent(index, newName, newMarks);
    }

    private static void deleteStudentFlow(GradeManager manager, Scanner scanner) {
        manager.listStudents();
        System.out.print("Enter student number to delete: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        manager.deleteStudent(index);
    }
}
