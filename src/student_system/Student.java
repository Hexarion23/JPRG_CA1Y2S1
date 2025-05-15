package student_system;

public class Student {

    private String adminNumber;
    private String name;
    private String[] books;
    private static int totalStudents = 0;

    public Student(String adminNumber, String name, String[] books) {
        this.adminNumber = adminNumber;
        this.name = name;
        this.books = books;
        totalStudents++;
    }

    public String getAdminNumber() {
        return adminNumber;
    }

    public String getName() {
        return name;
    }

    public void setBooks(String[] books) {
        this.books = books;
    }

    public String[] getBooks() {
        return books;
    }
    
}
