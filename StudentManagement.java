/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Studentsystem;

import javax.swing.JOptionPane;

public class StudentManagement {

    private Student[] students = new Student[1000000];
    private int studentCount = 0;

    public void loadSampleStudents() {
        students[studentCount++] = new Student("p111111", "John Tan", null);
        students[studentCount++] = new Student("p222222", "Peter Goh", null);
        students[studentCount++] = new Student("p333333", "Jack Lim", null);
        students[studentCount++] = new Student("p444444", "Sarah Lee", null);
        students[studentCount++] = new Student("p555555", "Alicia Wong", null);
        students[studentCount++] = new Student("p666666", "David Chan", null);
        students[studentCount++] = new Student("p777777", "Nurul Amin", null);
        students[studentCount++] = new Student("p888888", "Marcus Teo", null);
    }

    public void createStudent() {
        String admin = JOptionPane.showInputDialog(null, "Enter Admin Number:");
        String name = JOptionPane.showInputDialog(null, "Enter Name:");
        String[] books = null;

        if (studentCount < students.length) {
            students[studentCount] = new Student(admin, name, books);
            studentCount++;
            JOptionPane.showMessageDialog(null, "Student created.");
        } else {
            JOptionPane.showMessageDialog(null, "Student limit reached.");
        }
    }

    public void showAllStudents() {
        if (studentCount == 0) {
            JOptionPane.showMessageDialog(null, "No students to display.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < studentCount; i++) {
            sb.append("Name: ").append(students[i].getName()).append("\n");
            sb.append("Admin number: ").append(students[i].getAdminNumber()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void searchStudentByName() {
        String searchName = JOptionPane.showInputDialog(null, "Enter the Student name to search:");
        boolean found = false;

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getName().equalsIgnoreCase(searchName)) {
                JOptionPane.showMessageDialog(null, "Admin: " + students[i].getAdminNumber() + "\nName: " + students[i].getName());
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Cannot find the student " + searchName);
        }
    }

    public void displayNumberOfStudents() {
        JOptionPane.showMessageDialog(null, "Total number of students: " + studentCount);
    }

    public void displayStudentMenu() {
        while (true) {
            String enteredNumberForMainMenu = JOptionPane.showInputDialog(
                    null,
                    "Enter your option:\n1. Display all students\n2. Search student by name\n3. Add new student\n4. Display total number of students\n5. Exit"
            );

            if (enteredNumberForMainMenu == null) {
                break;
            }

            int option;
            try {
                option = Integer.parseInt(enteredNumberForMainMenu);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                continue;
            }

            switch (option) {
                case 1:
                    showAllStudents();
                    break;
                case 2:
                    searchStudentByName();
                    break;
                case 3:
                    createStudent();
                    break;
                case 4:
                    displayNumberOfStudents();
                    break;
                case 5:
                    return; // Exit the menu loop
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option.");
            }
        }
    }

    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        sm.loadSampleStudents();
        sm.displayStudentMenu();
    }

}
