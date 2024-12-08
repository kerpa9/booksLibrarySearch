package libraryBook.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import libraryBook.Library.domain.models.Authors;

public interface AuthorsRepository extends JpaRepository<Authors, Long> {

}
