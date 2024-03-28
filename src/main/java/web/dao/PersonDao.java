package web.dao;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional(readOnly = true)
    public List<Person> index(){
        return entityManager.createQuery("select p from Person p", Person.class)
                .getResultList();
    }

    @Transactional
    public Person showOne(int id){

        return entityManager.find(Person.class, id);
    }
    @Transactional
    public void save(Person person) {
        entityManager.persist(person);
    }

    @Transactional
    public void update(Person updatedPerson) {
        entityManager.merge(updatedPerson);
    }

    @Transactional
    public void delete(int id){
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);

            }
        }


