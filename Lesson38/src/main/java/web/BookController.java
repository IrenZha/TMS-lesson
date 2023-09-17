package web;

import domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.BookService;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "book")
public class BookController {
    private final BookService bookService;
    private final ModelAndView modelAndView = new ModelAndView("book");

    @GetMapping
    public ModelAndView getBook(@RequestParam(name = "search", required = false) String search) {
        if (search != null) {
            modelAndView.addObject("books", bookService.search(search));
        } else {
            modelAndView.addObject("books", bookService.getBooks());
        }
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addBook(Book book) {
        bookService.saveBook(book);
        modelAndView.addObject("books", bookService.getBooks());
        return modelAndView;
    }
}
