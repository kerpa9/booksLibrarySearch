package libraryBook.Library.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataLanguagesDTO(
        @JsonAlias("languages") String [] languages

) {

}
