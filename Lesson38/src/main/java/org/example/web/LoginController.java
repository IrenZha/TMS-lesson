package org.example.web;

import lombok.RequiredArgsConstructor;
import org.example.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/login")
public class LoginController {
    private final BookService bookService;

    @PostMapping
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("book");
        modelAndView.addObject("books", bookService.getBooks());
        return modelAndView;
    }
}
