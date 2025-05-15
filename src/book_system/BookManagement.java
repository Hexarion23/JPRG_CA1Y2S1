package book_system;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BookManagement {

    private static List<Book> bookList = new ArrayList<>();

    public static void displayAllBooks() {
        String message = "";

        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            message += "Book " + (i+1)
                + "\nBook Title: " + book.getTitle()
                + "\nBook Author: " + book.getAuthor()
                + "\nAvailability: " + book.getAvailable()
                + "\n";
        }

        JOptionPane.showMessageDialog(null, message, "All Books", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void searchBookByTitle() {
        String titleInput = JOptionPane.showInputDialog(null, "Enter the book name to search: ", "Input", JOptionPane.QUESTION_MESSAGE);

        boolean isNotFound = true;

        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);

            if (titleInput.equals(book.getTitle())) {
                String message = "Book " + (i+1)
                        + "\nBook Title: " + book.getTitle()
                        + "\nBook Author: " + book.getAuthor()
                        + "\nAvailability: " + book.getAvailable()
                        + "\n";
                JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);

                isNotFound = false;
            }
        }

        if (isNotFound) {
            String message = "Cannot find the book \"" + titleInput + "\".";
            JOptionPane.showMessageDialog(null, message, "Info", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void addNewBook() {

        String titleInput = JOptionPane.showInputDialog(null, "Enter the new book title: ", "Input", JOptionPane.QUESTION_MESSAGE);
        String authorInput = JOptionPane.showInputDialog(null, "Enter the new book author: ", "Input", JOptionPane.QUESTION_MESSAGE);
        String isbnInput = JOptionPane.showInputDialog(null, "Enter the new book ISBN: ", "Input", JOptionPane.QUESTION_MESSAGE);
        double priceInput = 0;

        boolean isErrorParsing = false;
        do {
            try {
                priceInput = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the new book price: ", "Input", JOptionPane.QUESTION_MESSAGE));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Only numbers and decimals are allowed for book price.", "Error", JOptionPane.ERROR_MESSAGE);
                isErrorParsing = true;
            }
        } while (isErrorParsing);

        String categoryInput = JOptionPane.showInputDialog(null, "Enter the new book category: ", "Input", JOptionPane.QUESTION_MESSAGE);

        Book newBook = new Book(titleInput, authorInput, isbnInput, priceInput, categoryInput, true);
        bookList.add(newBook);

        JOptionPane.showMessageDialog(null, "Book Added", "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void displayTotalBookCost() {
        double totalCost = 0;

        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);
            totalCost += book.getPrice();
        }
        JOptionPane.showMessageDialog(null, String.format("Total book cost is $%.2f", totalCost), "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
