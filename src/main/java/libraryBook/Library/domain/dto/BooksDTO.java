package libraryBook.Library.domain.dto;

import java.util.Arrays;

public record BooksDTO(

                String name,
                String[] languages,
                Double numDownload

) {

    
    @Override
    public final String toString() {
        return """
               
               -------------Book-------------
               
               Title: """ + name + "\n" +
                "Languages: " + Arrays.toString(languages).replace("[", "").replace("]", "") + "\n" +
                "Downloads parameters: " + numDownload + "\n" + "\n" +
                "------------------------------";
    }

}
