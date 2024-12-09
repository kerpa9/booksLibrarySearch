package libraryBook.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import libraryBook.Library.domain.models.Authors;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long> {


}
