package libraryBook.Library.domain.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import libraryBook.Library.domain.dto.DataAuthorsDTO;
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
    @ElementCollection
    private String[] languages;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Authors> authors = new ArrayList<>();

    public Books() {
    }

    public Books(DataResultsDTO data) {
        this.name = data.title();
        this.languages = data.languages();
        this.numDownload = data.numDownload();

        // Create authors and set the book reference
        if (data.authors() != null) {
            for (DataAuthorsDTO authorDTO : data.authors()) {
                Authors author = new Authors(authorDTO, this);
                this.authors.add(author);
            }
        }
    }

    // public Books(DataResultsDTO book) {
    //     this.name = book.title();
    //     this.numDownload = book.numDownload();
    //     this.languages = book.languages();
    // }

}