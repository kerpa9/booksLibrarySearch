package libraryBook.Library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import libraryBook.Library.domain.models.Books;


public interface BooksRepository extends JpaRepository<Books, Long> {
}
