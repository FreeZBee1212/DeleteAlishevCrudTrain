package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.PersonDao;
import web.model.Person;

import java.util.List;

@Service
@Transactional
public class PersonService {
    private PersonDao personDao;

    @Autowired
    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Transactional(readOnly = true)
    public List<Person> index(){
        return personDao.index();
    }

    public Person showOne(int id){
        return personDao.showOne(id);
    }

    public void save(Person person) {
        personDao.save(person);
    }


    public void update(Person updatedPerson) {
        personDao.update(updatedPerson);
    }



    public void delete(int id){
//        entityManager.remove(entityManager.find(Person.class, id));
        personDao.delete(id);
    }
}
