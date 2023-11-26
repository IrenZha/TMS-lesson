package com.example.lesson50.web;

import com.example.lesson50.dto.PersonDto;
import com.example.lesson50.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class HomeController {
    private final PersonService service;

    @GetMapping("/public")
    public String publicPage() {
        return "public";
    }

    @PostMapping("/public")
    public String save(@ModelAttribute(name = "person") PersonDto person) {
        service.save(person);
        return "public";
    }

    @GetMapping("/private")
    public ModelAndView privatePage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        ModelAndView modelAndView = new ModelAndView("private");
        modelAndView.addObject("username", name);
        return modelAndView;
    }
    @GetMapping("/read")
    public ModelAndView read() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        ModelAndView modelAndView = new ModelAndView("read");
        modelAndView.addObject("username", name);
        return modelAndView;
    }

    @GetMapping("/write")
    public ModelAndView write() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        ModelAndView modelAndView = new ModelAndView("write");
        modelAndView.addObject("username", name);
        return modelAndView;
    }
}
