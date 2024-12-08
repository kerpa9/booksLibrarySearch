package libraryBook.Library.domain.dto;

public class AuthorDTO {

    String name;
    Integer birthYear;
    Integer deathYear;

    public AuthorDTO(DataAuthorsDTO data) {
        this.name = data.name();
        this.birthYear = data.birthYear();
        this.deathYear = data.deathYear();

    }

}
