package libraryBook.Library.domain.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataResultsDTO(
        @JsonAlias("title") String title,
        @JsonAlias("languages") String [] languages,
        @JsonAlias("authors") List<DataAutorDTO> authors,
        @JsonAlias("download_count") String download

) {

}
