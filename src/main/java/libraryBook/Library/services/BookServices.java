package libraryBook.Library.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import libraryBook.Library.domain.dto.BooksDTO;
import libraryBook.Library.repository.BooksRepository;

@Service
public class BookServices {

    @Autowired
    private BooksRepository booksRepository;

    public List<BooksDTO> allBooks() {
        return booksRepository.findAll().stream()
                .map(b -> new BooksDTO(b.getName(), b.getNumDownload()))
                .collect(Collectors.toList());
    }

}
