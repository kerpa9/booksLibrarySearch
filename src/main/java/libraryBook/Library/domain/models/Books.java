package libraryBook.Library.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Double numDownload;
    private String[] languages;

    public Books() {
    }

    public Books(DataResultsDTO book) {
        this.name = book.title();
        this.numDownload = book.numDownload();
        this.languages = book.languages();
    }

}