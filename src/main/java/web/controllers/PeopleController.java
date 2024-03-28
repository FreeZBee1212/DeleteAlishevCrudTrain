package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.PersonDao;
import web.model.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {
    PersonDao personDao;

    @Autowired
    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("index", personDao.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("show", personDao.showOne(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping()
    public String createPerson(@ModelAttribute("person") Person person) {
        personDao.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDao.showOne(id));
        return "people/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        personDao.update(person);
        return "redirect:/people";
    }

    //    @DeleteMapping("/{id}")
//    public String Delete(@PathVariable("id") int id, Person person){
//        personDao.delete(id);
//        return "redirect:/people";
//    }
    @PostMapping("/delete")
    public String Delete(@RequestParam("id") int id) {
        personDao.delete(id);
        return "redirect:/people";
    }
}
