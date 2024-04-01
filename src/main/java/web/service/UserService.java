package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();

    public User showOneUser(int id);

    public void saveUser(User user);

    public void updateUser(User updatedUser);

    public void deleteUser(User user);

}
