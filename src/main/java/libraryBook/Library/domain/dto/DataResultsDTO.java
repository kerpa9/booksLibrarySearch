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
                                "Authors: " + Arrays.toString(authors).replace("[", "").replace("]", "") + "\n" +
                                "Languages: " + Arrays.toString(languages).replace("[", "").replace("]", "") + "\n" +
                                "Downloads parameters: " + numDownload + "\n" + "\n" +
                                "------------------------------";
        }

}
