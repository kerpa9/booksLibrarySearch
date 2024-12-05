package libraryBook.Library.principalMenu;

import java.util.Scanner;

import libraryBook.Library.domain.dto.DataResultsDTO;
import libraryBook.Library.domain.models.Books;
import libraryBook.Library.helpers.ConsultLibraryAPI;
import libraryBook.Library.helpers.ConverterDataBooks;
import libraryBook.Library.repository.BooksRepository;

public class PrincipalMenuBook {
    private ConsultLibraryAPI consultLibraryAPI = new ConsultLibraryAPI();
    private Scanner write = new Scanner(System.in);
    private ConverterDataBooks converterDataBooks = new ConverterDataBooks();
    private BooksRepository booksRepository;

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

                case 1:

                    // String json = consultLibraryAPI.consultAPI("https://gutendex.com/books/");
                    // System.out.println(json);
                    // getBookData();
                    searchBooks();
                    break;
                case 2:
                    System.out.println("Recorded list books");
                    break;
                case 3:
                    System.out.println("Recorded autors list");
                    break;
                case 4:
                    System.out.println("List living authors in a specific year");
                    break;
                case 5:
                    System.out.println("Books by Language List");
                    break;
                case 0:
                    System.out.println("Close this app, thanks");
                    break;
                default:
                    System.out.println("Option not found");

            }

        }

    }

    public DataResultsDTO getBookData() {

        System.out.print("Write the book: ");

        String book = write.nextLine();

        String url = "https://gutendex.com/books/?search=" + book;

        var json = consultLibraryAPI.consultAPI(url);

        DataResultsDTO data = converterDataBooks.obtainData(json, DataResultsDTO.class);

        // System.out.println(data.results().get(0).toString());
        return data;

    }

    public void searchBooks() {
        DataResultsDTO book = getBookData();

        Books books = new Books(book);
        booksRepository.save(books);
        System.out.println(books);
    }

}
