package libraryBook.Library.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import libraryBook.Library.domain.dto.DataAuthorsDTO;
import lombok.Getter;

@Getter
@Entity
@Table(name = "authors")
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String name;
    private Integer birthYear;
    private Integer deathYear;

    @ManyToOne
    private Books book;

    public Authors() {
    }

    // Constructor from DataAuthorsDTO
    public Authors(DataAuthorsDTO authorDTO, Books book) {
        this.name = authorDTO.name();
        this.birthYear = authorDTO.birthYear();
        this.deathYear = authorDTO.deathYear();
        this.book = book;
    }

    @Override
    public final String toString() {
        return """
               
               -------------Author: """ + id + "-------------" + "\n" + "\n" +

                "Title: " + name + "\n" +
                "Birth Year: " + birthYear + "\n" +
                "Death Year: " + deathYear + "\n" +
                "Relation Book: " + book.getName() + "\n" + "\n" +
                "------------------------------";
    }

}
