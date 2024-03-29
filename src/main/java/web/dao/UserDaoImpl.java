package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl {

    @PersistenceContext
    private EntityManager entityManager;


    public List<User> index() {
        return entityManager.createQuery("select p from User p", User.class)
                .getResultList();
    }


    public User showOneUser(int id) {

        return entityManager.find(User.class, id);
    }

    public void saveUser(User user) {
        entityManager.persist(user);
    }


    public void updateUser(User updatedUser) {
        entityManager.merge(updatedUser);
    }


    public void deleteUser(int id) {
        entityManager.remove(id);
    }
}
