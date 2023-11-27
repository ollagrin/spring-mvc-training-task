package by.hrynko.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping()
    public String index(){
        return "main/index";
    }
    @GetMapping("/people")
    public String goToPeoplePage(){
        return "people/all";
    }
    @GetMapping("/books")
    public String goToBooksPage(){
        return "book/books";
    }
}
