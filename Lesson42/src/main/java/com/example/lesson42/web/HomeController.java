package com.example.lesson42.web;

import com.example.lesson42.domain.StudentDto;
import com.example.lesson42.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class HomeController {
    private final StudentService service;

    @GetMapping
    public ModelAndView getHomePage(@ModelAttribute(name = "student") StudentDto student) {
        var students = service.order();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("students", students);

        return modelAndView;
    }

    @PostMapping
    public ModelAndView save(@ModelAttribute(name = "student") @Valid StudentDto student, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("home");
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (var error : errors) {
                String field = error.getField();
                String message = error.getDefaultMessage();
                modelAndView.addObject(field + "_error", message);
            }
        } else {
            service.save(student);

        }
        var students = service.order();
        modelAndView.addObject("students", students);
        return modelAndView;
    }

    @PostMapping(value = "/order")
    public ModelAndView getOrderPage(@ModelAttribute(name = "student") StudentDto student,
                                     @RequestParam(name = "id") UUID id,
                                     @RequestParam(name = "update") String update) {
        if (update != null) {
            try {
                service.update(id, update);
            } catch (Exception ignored) {
            }
        }
        var students = service.order();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("students", students);
        return modelAndView;
    }
}