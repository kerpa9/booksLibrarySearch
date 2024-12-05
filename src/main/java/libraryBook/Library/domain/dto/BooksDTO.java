package libraryBook.Library.domain.dto;

public record BooksDTO(

                String name,
                // List<DataAutorDTO> authors,
                String[] languages,
                String numDownload

) {

}
