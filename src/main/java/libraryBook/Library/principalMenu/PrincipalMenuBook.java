package libraryBook.Library.principalMenu;

import java.util.Scanner;

public class PrincipalMenuBook {

    public void optionsBooksLibrary() {

        var option = -1;

        Scanner write = new Scanner(System.in);

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
                    System.out.println("Search book for title");
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

}
