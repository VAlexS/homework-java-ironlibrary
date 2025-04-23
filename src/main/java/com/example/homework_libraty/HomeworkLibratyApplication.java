package com.example.homework_libraty;

import com.example.homework_libraty.models.Author;
import com.example.homework_libraty.models.Book;
import com.example.homework_libraty.repositories.AuthorRepository;
import com.example.homework_libraty.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@SpringBootApplication
public class HomeworkLibratyApplication {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	// ANSI CODES for colors
	public static final String RESET = "\u001B[0m";
	public static final String GREEN = "\u001B[32m";
	public static final String CYAN = "\u001B[36m";
	public static final String YELLOW = "\u001B[33m";
	public static final String RED = "\u001B[31m";

	private final Scanner scanner = new Scanner(System.in);

	public void addBook() {
		System.out.print("Enter the isbn: ");
		String isbn = scanner.nextLine().trim();
		if (isbn.isEmpty()) {
			throw new IllegalArgumentException("ISBN cannot be empty.");
		}

		System.out.print("Enter the title of the book: ");
		String title = scanner.nextLine().trim();
		if (title.isEmpty()) {
			throw new IllegalArgumentException("Book title cannot be empty.");
		}

		System.out.print("Enter the category of the book: ");
		String category = scanner.nextLine().trim();
		if (category.isEmpty()) {
			throw new IllegalArgumentException("Book category cannot be empty.");
		}

		System.out.print("Enter the author of the book: ");
		String authorName = scanner.nextLine().trim();
		if (authorName.isEmpty()) {
			throw new IllegalArgumentException("Author cannot be empty.");
		}

		System.out.print("Enter the mail of the author: ");
		String mail = scanner.nextLine().trim();
		if (mail.isEmpty()) {
			throw new IllegalArgumentException("Author mail cannot be empty.");
		}

		System.out.print("Enter the number of books: ");
		int booksNumber = Integer.parseInt(scanner.nextLine().trim());
		if (booksNumber <= 0) {
			throw new IllegalArgumentException("Book number cannot be 0 or less.");
		}

		Book book = new Book(isbn, title, category, booksNumber);
		Author author = new Author(authorName, mail, book);

		bookRepository.save(book);
		authorRepository.save(author);

		System.out.println("Record created successfully!");
	}

	public void searchBook() {
		System.out.print("Enter the title of the book: ");
		String title = scanner.nextLine().trim();
		if (title.isEmpty()) {
			throw new IllegalArgumentException("Book title cannot be empty.");
		}

		Book book = bookRepository.findByTitle(title);
		if (book != null) {
			System.out.println("Book found: " + book);
		} else {
			System.out.println("Book not found.");
		}
	}

	public void menuDisplay() {
		System.out.println(GREEN + "\n======== 📖 Iron Library ========" + RESET);
		System.out.println(CYAN + "1. 📕 Add a book" + RESET);
		System.out.println(CYAN + "2. 🔎 Search book by title" + RESET);
		System.out.println(CYAN + "3. 🗂️ Search book by category" + RESET);
		System.out.println(CYAN + "4. 🖋️ Search book by author" + RESET);
		System.out.println(CYAN + "5. 📚 List all books along with author" + RESET);
		System.out.println(CYAN + "6. 🎓 Issue book to student" + RESET);
		System.out.println(CYAN + "7. 🆔 List books by USN" + RESET);
		System.out.println(GREEN + "---------------------------------" + RESET);
		System.out.println(RED + "8. 🚪 Exit" + RESET);
		System.out.println(GREEN + "=================================" + RESET);
		System.out.print("Choose an option: ");
	}

	public void runMenu() {
		boolean running = true;

		while (running) {
			try {
				menuDisplay();
				String option = scanner.nextLine();

				switch (option) {
					case "1":
						addBook();
						break;
					case "2":
						searchBook();
						break;
					case "3":
						searchBookByCategory();
						break;
					case "4":
						// TODO
						break;
					case "5":
						// TODO
						break;
					case "6":
						// TODO
						break;
					case "7":
						// TODO
						break;
					case "8", "exit":
						running = false;
						break;
					default:
						System.out.println("Invalid option. Please try again.");
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

	public void searchBookByCategory() {
		List<Book> books;
		System.out.print("Enter the category of the book: ");
		String category = scanner.nextLine().trim();
		if (category.isEmpty()) {
			throw new IllegalArgumentException("Book category cannot be empty.");
		}

		books = bookRepository.findByCategory(category);
		if (!books.isEmpty()) {
			System.out.println("Books found in category " + category + ":");
			for (Book book : books) {
				System.out.println(book);
			}
		} else {
			System.out.println("Book category not found.");
		}
	}





	//TODO: hacer el 5 (List all books along with author) y la 7 (List all books along with author)

	public static void main(String[] args) {

		// Run the Spring Boot application
		ConfigurableApplicationContext context = SpringApplication.run(HomeworkLibratyApplication.class, args);

		// Get the IronlibraryApplication bean from the context
		HomeworkLibratyApplication app = context.getBean(HomeworkLibratyApplication.class);

		app.runMenu();

		// Close the application context
		SpringApplication.exit(context);
	}

}
