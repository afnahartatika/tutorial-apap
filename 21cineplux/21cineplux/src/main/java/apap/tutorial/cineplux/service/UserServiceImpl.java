package apap.tutorial.cineplux.service;

import apap.tutorial.cineplux.model.PenjagaModel;
import apap.tutorial.cineplux.model.UserModel;
import apap.tutorial.cineplux.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDB userDB;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDB.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    // latihan no 1 - tutorial 6
    @Override
    public List<UserModel> getListUser() {
        return userDB.findAll();
    }

    // latihan no 2 - tutorial 6
    @Override
    public void deleteUser(UserModel user) {
        userDB.delete(user);
    }

    @Override
    public UserModel getUserByUsername(String username) {
        UserModel user = userDB.findByUsername(username);
        return user;
    }

    // latihan no 4 - tutorial 6
    @Override
    public void updatePassword(UserModel user, String password) {
        String passwordBaru = encrypt(password);
        user.setPassword(passwordBaru);
        userDB.save(user);
    }

}
