package libraryBook.Library.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import libraryBook.Library.domain.dto.BooksDTO;
import libraryBook.Library.domain.dto.DataResultsDTO;
import lombok.Getter;

@Getter
@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    // private List<DataAutorDTO> authors;
    private String[] languages;
    private String numDownload;

    public Books() {
    }

    public Books(BooksDTO booksDTO) {

        this.name = booksDTO.name();
        // this.authors = booksDTO.authors();
        this.languages = booksDTO.languages();
        this.numDownload = booksDTO.numDownload();
    }

    public Books(DataResultsDTO book) {
        this.name = book.name();
        // this.authors = book.authors();
        this.languages = book.languages();
        this.numDownload = book.numDownload();
    }

    // public Books(DataBooksDTO book) {
    // //TODO Auto-generated constructor stub
    // }

    @Override
    public String toString() {
        return "Genre= " + name +
                // ", Title= " + authors + '\'' +
                ", numEpisodes= " + languages +
                ", Evaluation= " + numDownload;

    }

}