package libraryBook.Library.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import libraryBook.Library.domain.dto.BooksDTO;

@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    private String autors;
    private String language;
    private String numDownload;

    public Books(BooksDTO booksDTO) {
        
        this.name = booksDTO.name();
        this.autors = booksDTO.autors();
        this.language = booksDTO.language();
        this.numDownload = booksDTO.numDownload();

    }

}
