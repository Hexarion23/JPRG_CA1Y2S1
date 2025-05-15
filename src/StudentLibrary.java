import javax.swing.JOptionPane;

import book_system.BookManagement;
import student_system.StudentManagement;

public class StudentLibrary {
    public static void main(String[] args) {
        String mainPrompt = "Enter your option: " +
                "\n\n1. Student management" +
                "2. Books in library" +
                "3. Exit\n";

        String enteredNumberForMainMenu = JOptionPane.showInputDialog(
                null,
                "Enter your option:\n" + 
                "1. Student management\n" +
                "2. Books in library\n" +
                "3. Exit");

        int option = Integer.parseInt(enteredNumberForMainMenu);
        switch(option) {
            case 1: StudentManagement.promptStudentMainMenu();
            case 2: BookManagement.promptBookMainMenu();
        }

    }
}
