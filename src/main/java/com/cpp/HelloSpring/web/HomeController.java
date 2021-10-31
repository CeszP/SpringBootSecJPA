package com.cpp.HelloSpring.web;

import com.cpp.HelloSpring.service.PersonService;
import com.cpp.HelloSpring.dao.PersonDao;
import com.cpp.HelloSpring.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//SPRING MVC CONTROLLER ANNOTATION
@Controller
@Slf4j
public class HomeController {
    
    //Injecting PersonDao Interface
    @Autowired
    private PersonService personService;
    
    @GetMapping("/")
    public String home(Model model) {
        
        var people = personService.listPeople();
        model.addAttribute("peop", people);
        
        return "index";
    }
    @GetMapping("/add")
    public String add(Person person){
        return "modify";
    }
    
    @PostMapping("/save")
    public String save(Person person){
        personService.save(person);
        return "redirect:/";
    }
    
    @GetMapping("/edit/{id_person}")
    public String edit(Person person, Model model){
        person = personService.findPerson(person);
        model.addAttribute("person", person);
        return "modify";
    }
    
    @GetMapping("/delete")
    public String delete(Person person){
        personService.delete(person);
        return "redirect:/";
    }
}
