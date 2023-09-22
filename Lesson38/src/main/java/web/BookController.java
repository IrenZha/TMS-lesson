package web;

import domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.BookService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/book")
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
    public ModelAndView addBook(@Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (var error : errors) {
                String field = error.getField();
                String message = error.getDefaultMessage();
                modelAndView.addObject(field + "_error", message);
            }
        } else {
            bookService.saveBook(book);
        }
        modelAndView.addObject("books", bookService.getBooks());
        return modelAndView;
    }
}
