package libraryBook.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import libraryBook.Library.principalMenu.PrincipalMenuBook;
import libraryBook.Library.repository.BooksRepository;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	@Autowired
	private BooksRepository booksRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		PrincipalMenuBook principalMenu = new PrincipalMenuBook(booksRepository);

		principalMenu.optionsBooksLibrary();
	}

}
