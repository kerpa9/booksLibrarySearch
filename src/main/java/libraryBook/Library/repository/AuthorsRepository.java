package libraryBook.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import libraryBook.Library.domain.models.Authors;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long> {

    @Query(value = "SELECT * FROM authors a WHERE a.death_year IS NOT NULL AND a.death_year > :year", nativeQuery = true)
    List<Authors> listAuthorsLive(Integer year);

}
