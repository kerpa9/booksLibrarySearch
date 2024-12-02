package libraryBook.Library.principalMenu;

import java.util.Scanner;

import libraryBook.Library.domain.dto.DataBooksDTO;
import libraryBook.Library.helpers.ConsultLibraryAPI;
import libraryBook.Library.helpers.ConverterDataBooks;

public class PrincipalMenuBook {
    ConsultLibraryAPI consultLibraryAPI = new ConsultLibraryAPI();
    Scanner write = new Scanner(System.in);
    ConverterDataBooks converterDataBooks = new ConverterDataBooks();

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


                    ************************************************************
                    """;

            System.out.println(menu);
            System.out.print("Option selected: ");
            option = write.nextInt();
            write.nextLine();

            switch (option) {

                case 1:

                    // String json = consultLibraryAPI.consultAPI("https://gutendex.com/books/");
                    // System.out.println(json);
                    bookForTitle();
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

    public DataBooksDTO bookForTitle() {

        String url = "https://gutendex.com/books/?search=harry";

        var json = consultLibraryAPI.consultAPI(url);

        DataBooksDTO data = converterDataBooks.obtainData(json, DataBooksDTO.class);

        System.out.println(data.results().get(0).toString());
        return data;

    }

}
