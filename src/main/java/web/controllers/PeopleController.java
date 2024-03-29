package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.PersonDao;
import web.model.Person;
import web.service.PersonService;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonService personService;

    @Autowired
    public PeopleController(PersonService personService) {
        this.personService = personService;
    }




    @GetMapping()
    public String index(Model model) {
        model.addAttribute("index", personService.index());
        return "people/index";
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("show", personDao.showOne(id));
//        return "people/show";
//    }
@GetMapping("/id")
public String show(@RequestParam("id") int id, Model model) {
    model.addAttribute("show", personService.showOne(id));
    return "people/show";
}

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    public String createPerson(@ModelAttribute("person") Person person) {
        personService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/id/edit")
    public String edit(Model model, @RequestParam("id") int id) {
        model.addAttribute("person", personService.showOne(id));
        return "people/edit";
    }

//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id) {
//        model.addAttribute("person", personDao.showOne(id));
//        return "people/edit";
//    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("person") Person person) {
        personService.update(person);
        return "redirect:/people";
    }

    //    @DeleteMapping("/{id}")
//    public String Delete(@PathVariable("id") int id, Person person){
//        personDao.delete(id);
//        return "redirect:/people";
//    }
    @PostMapping("/delete")
    public String Delete(@RequestParam("id") int id) {
        personService.delete(id);
        return "redirect:/people";
    }
}
