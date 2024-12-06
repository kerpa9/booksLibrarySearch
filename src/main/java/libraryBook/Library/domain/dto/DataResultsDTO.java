package libraryBook.Library.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataResultsDTO(
        @JsonAlias("title") String title,
        // @JsonAlias("languages") List<String> languages,
        @JsonAlias("download_count") Double numDownload

) {

}
