package com.example.homework_library;

import com.example.homework_library.models.Author;
import com.example.homework_library.models.Book;
import com.example.homework_library.models.Issue;
import com.example.homework_library.models.Student;
import com.example.homework_library.services.AuthorService;
import com.example.homework_library.services.BookService;
import com.example.homework_library.services.IssueService;
import com.example.homework_library.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@SpringBootApplication
public class HomeworkLibraryApplication {

    @Autowired
    private BookService bookService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private IssueService issueService;

    @Autowired
    private AuthorService authorService;

    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    public static final String RED = "\u001B[31m";

    private final Scanner scanner = new Scanner(System.in);

    public void runMenu() {
        boolean running = true;

        while (running) {
            try {
                menuDisplay();
                String option = scanner.nextLine().trim();

                switch (option) {
                    case "1" -> addBook();
                    case "2" -> searchBook();
                    case "3" -> searchBookByCategory();
                    case "4" -> findBookByAuthor();
                    case "5" -> listAllBooks();
                    case "6" -> issueBook();
                    case "7" -> listAllBooksByUSN();
                    case "8" -> listAllStudents();
                    case "9" -> listAllAuthors();
                    case "0", "exit" -> running = false;
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Incorrect argument: " + e.getMessage());
            } catch (NoSuchElementException e) {
                System.out.println("Element not found: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private void menuDisplay() {
        System.out.println(GREEN + "\n=========== 📖 Iron Library ===========" + RESET);
        System.out.println(CYAN + "1. 📕 Add a book" + RESET);
        System.out.println(CYAN + "2. 🔎 Search book by title" + RESET);
        System.out.println(CYAN + "3. 🗂️ Search book by category" + RESET);
        System.out.println(CYAN + "4. 🖋️ Search book by author" + RESET);
        System.out.println(CYAN + "5. 📚 List all books along with author" + RESET);
        System.out.println(CYAN + "6. 🎓 Issue book to student" + RESET);
        System.out.println(CYAN + "7. 🆔 List books by USN" + RESET);
        System.out.println(CYAN + "8. 👩‍🎓 List all students" + RESET);
        System.out.println(CYAN + "9. ✍️ List all authors" + RESET);
        System.out.println(GREEN + "-----------------------------------------" + RESET);
        System.out.println(RED + "0. 🚪 Exit" + RESET);
        System.out.println(GREEN + "=========================================" + RESET);
        System.out.print("Choose an option: ");
    }

    private void addBook() {
        String isbn = prompt("Enter the ISBN: ");
        String title = prompt("Enter the title of the book: ");
        String category = prompt("Enter the category of the book: ");
        String authorName = prompt("Enter the author of the book: ");
        String mail = prompt("Enter the mail of the author: ");
        int booksNumber = Integer.parseInt(prompt("Enter the number of books: "));

        bookService.addBook(isbn, title, category, authorName, mail, booksNumber);
        System.out.println("Record created successfully!");
    }

    private void searchBook() {
        String title = prompt("Enter the title of the book: ");
        Book book = bookService.searchBookByTitle(title);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    private void searchBookByCategory() {
        String category = prompt("Enter the category of the book: ");
        List<Book> books = bookService.searchBooksByCategory(category);
        if (!books.isEmpty()) {
            System.out.println("Books found in category " + category + ":");
            books.forEach(System.out::println);
        } else {
            System.out.println("Book category not found.");
        }
    }

    private void findBookByAuthor() {
        String authorName = prompt("Enter the author of the book: ");
        Book book = bookService.findBookByAuthor(authorName);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    private void listAllBooks() {
        List<Book> books = bookService.listAllBooks();

        String separator = String.format("%-90s", "").replace(' ', '=');

        System.out.println(separator);
        System.out.printf("%-25s %-30s %-20s %-10s%n",
                "Book ISBN", "Book Title", "Category", "Quantity");
        System.out.println(separator);

        for (Book book : books) {
            System.out.printf("%-25s %-30s %-20s %-10d%n",
                    book.getIsbn(), book.getTitle(), book.getCategory(), book.getQuantity());
        }

        System.out.println(separator);
    }

    private void listAllStudents() {
        List<Student> students = studentService.listAllStudents();

        String separator = String.format("%-50s", "").replace(' ', '=');

        System.out.println(separator);
        System.out.printf("%-20s %-30s%n", "USN", "Student Name");
        System.out.println(separator);

        for (Student student : students) {
            System.out.printf("%-20s %-30s%n", student.getUsn(), student.getName());
        }

        System.out.println(separator);
    }

    private void listAllAuthors() {
        List<Author> authors = authorService.findAll();

        String separator = String.format("%-60s", "").replace(' ', '=');

        System.out.println(separator);
        System.out.printf("%-30s %-30s%n", "Author Name", "Email");
        System.out.println(separator);

        for (Author author : authors) {
            System.out.printf("%-30s %-30s%n", author.getName(), author.getEmail());
        }

        System.out.println(separator);
    }


    private void issueBook() {
        String usn = prompt("Enter USN: ");
        String isbn = prompt("Enter ISBN: ");

        try {
            issueService.issueBook(usn, isbn);
            System.out.println("Book issued successfully!");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listAllBooksByUSN() {
        String usn = prompt("Enter USN: ");
        Issue issue = issueService.findIssueByStudentUsn(usn);
        if (issue != null) {
            System.out.println("Book found: " + issue.getIssueBook());
        } else {
            System.out.println("No books found for this USN.");
        }
    }

    private String prompt(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HomeworkLibraryApplication.class, args);

        HomeworkLibraryApplication app = context.getBean(HomeworkLibraryApplication.class);

        app.runMenu();

        SpringApplication.exit(context);

    }

}
