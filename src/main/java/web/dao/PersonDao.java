package web.dao;



import org.springframework.stereotype.Repository;
import web.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;



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
        entityManager.remove(index());
//        entityManager.remove(id);
            }
//    public void delete(int id) {
//        Person personToDelete = entityManager.find(Person.class, id);
//
//        if (personToDelete != null) {
//            entityManager.remove(personToDelete);
//        } else {
//            System.out.println("Person with id " + id + " not found for deletion");
//        }
//    }
}

//    public void delete(int id){
//        entityManager.remove(entityManager.find(Person.class, id));
////        entityManager.remove(id);
//            }
//        }


