package libraryBook.Library.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataResultsDTO(
    @JsonAlias("id") int id,
    @JsonAlias("title") String title

) {

}
