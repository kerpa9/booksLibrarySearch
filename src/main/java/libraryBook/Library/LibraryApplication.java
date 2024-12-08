package libraryBook.Library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import libraryBook.Library.principalMenu.PrincipalMenuBook;
import libraryBook.Library.repository.AuthorsRepository;
import libraryBook.Library.repository.BooksRepository;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	@Autowired
	private BooksRepository booksRepository;

	@Autowired
	private AuthorsRepository authorsRepository;

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		PrincipalMenuBook principalMenu = new PrincipalMenuBook(booksRepository);
		PrincipalMenuBook principalMenu1 = new PrincipalMenuBook(authorsRepository);

		principalMenu.optionsBooksLibrary();
	}

}
