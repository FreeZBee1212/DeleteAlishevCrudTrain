package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDaoImpl;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl {
    private final UserDaoImpl userDaoImpl;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @Transactional(readOnly = true)
    public List<User> index() {
        return userDaoImpl.index();
    }

    public User showOneUser(int id) {
        return userDaoImpl.showOneUser(id);
    }

    public void saveUser(User user) {
        userDaoImpl.saveUser(user);
    }

    public void updateUser(User updatedUser) {
        userDaoImpl.updateUser(updatedUser);
    }

    public void deleteUser(int id) {
        userDaoImpl.deleteUser(id);
    }
}
