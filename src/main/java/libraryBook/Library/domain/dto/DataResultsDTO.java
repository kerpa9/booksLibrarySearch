package libraryBook.Library.domain.dto;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataResultsDTO(
                @JsonAlias("title") String title,
                @JsonAlias("languages") String[] languages,
                @JsonAlias("download_count") Double numDownload,
                @JsonAlias("authors") DataAuthorsDTO[] authors

) {
        @Override
        public final String toString() {
                return "\n" + "-------------Book-------------" + "\n" + "\n" +
                                "Title: " + title + "\n" +
                                "Languages: " + Arrays.toString(languages) + "\n" +
                                "Downloads parameter: " + numDownload + "\n" +
                                "Authors" + Arrays.toString(authors) + "\n" + "\n" +
                                "------------------------------";
        }

}
