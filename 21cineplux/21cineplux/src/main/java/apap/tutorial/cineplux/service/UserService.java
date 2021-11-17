package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    List<UserModel> getListUser(); // latihan no 1 - tutorial 6
    void deleteUser(UserModel user); // latihan no 2 - tutorial 6
    UserModel getUserByUsername(String username); // latihan no 2 - tutorial 6
    void updatePassword(UserModel user, String password); // latihan no 4 - tutorial 6
}
