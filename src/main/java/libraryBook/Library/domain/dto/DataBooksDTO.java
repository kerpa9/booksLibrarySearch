package libraryBook.Library.domain.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataBooksDTO(

              @JsonAlias("next") String next,
              @JsonAlias("results") List<DataResultsDTO> results

) {

}
