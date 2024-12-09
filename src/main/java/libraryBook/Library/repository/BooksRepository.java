package libraryBook.Library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import libraryBook.Library.domain.models.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
    @Query(value = "SELECT * FROM books b WHERE :language = ANY(b.languages)", nativeQuery = true)
    List<Books> booksToLanguage(String language);

}
