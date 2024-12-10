package libraryBook.Library.principalMenu;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import libraryBook.Library.domain.dto.AuthorDTO;
import libraryBook.Library.domain.dto.BooksDTO;
import libraryBook.Library.domain.dto.DataResultsDTO;
import libraryBook.Library.domain.models.Authors;
import libraryBook.Library.domain.models.Books;
import libraryBook.Library.helpers.ConsultLibraryAPI;
import libraryBook.Library.helpers.ConverterDataBooks;
import libraryBook.Library.repository.AuthorsRepository;
import libraryBook.Library.repository.BooksRepository;

public class PrincipalMenuBook {
    private final ConsultLibraryAPI consultLibraryAPI = new ConsultLibraryAPI();
    private final Scanner write = new Scanner(System.in);
    private final ConverterDataBooks converterDataBooks = new ConverterDataBooks();
    // @Autowired
    private final BooksRepository repository;
    private final AuthorsRepository repositoryAuthor;

    private List<Books> bookslist;
    private List<Authors> authors;

    // Autowired
    public PrincipalMenuBook(BooksRepository booksRepository, AuthorsRepository authorRepository) {
        this.repository = booksRepository;
        this.repositoryAuthor = authorRepository;

    }

    public void optionsBooksLibrary() {

        var option = -1;

        while (option != 0) {

            String menu = """

                    ************************************************************

                    Choose a valid option

                    1 - Search book for title
                    2 - Recorded list books
                    3 - Recorded autors list
                    4 - List living authors in a specific year
                    5 - Books by Language List

                    0 - Close App


                    """;

            System.out.println(menu);
            System.out.print("Select a option: ");
            option = write.nextInt();
            write.nextLine();
            System.out.println("************************************************************");

            switch (option) {

                case 1 -> saveDataDB();
                case 2 -> viewBooksSearch();
                case 3 -> viewAuthorsList();
                case 4 -> {
                    listAuthorsYear();
                    System.out.println("List living authors in a specific year");
                }
                case 5 -> {
                    listBooksLanguages();
                    System.out.println("Books by Language List");
                }
                case 0 -> System.out.println("Close this app, thanks");
                default -> System.out.println("Option not found");

            }

        }

    }

    public DataResultsDTO getBookData() {

        System.out.print("Search the book: ");

        String book = write.nextLine();

        String url = "https://gutendex.com/books/?search=" + book;

        var json = consultLibraryAPI.consultAPI(url);

        DataResultsDTO data = converterDataBooks.obtainData(json, DataResultsDTO.class);
        System.out.println(data);

        return data;

    }

    public void saveDataDB() {
        DataResultsDTO book = getBookData();
        Books books = new Books(book);
        repository.save(books);

    }

    public void viewBooksSearch() {
        bookslist = repository.findAll();

        bookslist.stream().sorted(Comparator.comparing(Books::getName)).forEach(System.out::println);

    }

    public void viewAuthorsList() {
        // viewBooksSea rch();
        authors = repositoryAuthor.findAll();
        authors.stream().sorted(Comparator.comparing(Authors::getBirthYear)).forEach(System.out::println);
    }

    public List<AuthorDTO> listAuthorsYear() {
        System.out.println("Write ");
        Integer year = write.nextInt();
        System.out.println(repositoryAuthor.listAuthorsLive(year));
        return dataConverterAuthors(repositoryAuthor.listAuthorsLive(year));

    }

    public List<BooksDTO> listBooksLanguages() {
        System.out.println("Write ");
        String language = write.nextLine();
        System.out.println(dataConverterBooks(repository.booksToLanguage(language)));
        return dataConverterBooks(repository.booksToLanguage(language));

    }

    public List<AuthorDTO> dataConverterAuthors(List<Authors> autho) {

        return autho.stream().map(a -> new AuthorDTO(a.getName(), a.getBirthYear(), a.getDeathYear()))
                .collect(Collectors.toList());
    }

    public List<BooksDTO> dataConverterBooks(List<Books> book) {

        return book.stream()
                .map(b -> new BooksDTO(b.getName(), b.getLanguages(), b.getNumDownload())).collect(Collectors.toList());
    }

}
