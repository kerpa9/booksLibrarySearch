package libraryBook.Library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import libraryBook.Library.principalMenu.PrincipalMenuBook;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		PrincipalMenuBook principalMenu = new PrincipalMenuBook();
		
		principalMenu.optionsBooksLibrary();
	}

}
