package org.example.web;

import org.example.domain.Book;
import lombok.RequiredArgsConstructor;
import org.example.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/book")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ModelAndView getBook(@RequestParam(name = "search", required = false) String search) {
        ModelAndView modelAndView = new ModelAndView("book");
        if (search != null) {
            modelAndView.addObject("books", bookService.search(search));
        } else {
            modelAndView.addObject("books", bookService.getBooks());
        }
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addBook(@Valid Book book, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("book");
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
