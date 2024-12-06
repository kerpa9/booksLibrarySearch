package libraryBook.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import libraryBook.Library.domain.models.Books;

@Component
public interface BooksRepository extends JpaRepository<Books, Long> {
}
