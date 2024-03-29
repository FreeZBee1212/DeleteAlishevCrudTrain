package web.dao;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional(readOnly = true)
    public List<Person> index(){
        return entityManager.createQuery("select p from Person p", Person.class)
                .getResultList();
    }


    public Person showOne(int id){

        return entityManager.find(Person.class, id);
    }

    public void save(Person person) {
        entityManager.persist(person);
    }


    public void update(Person updatedPerson) {
        entityManager.merge(updatedPerson);
    }


    public void delete(int id){
        entityManager.flush();
        entityManager.remove(entityManager.find(Person.class, id));

            }
        }


