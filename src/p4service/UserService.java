package p4service;

import p2entity.User;
import p3dao.UserDao;

import java.util.ArrayList;
import java.util.Optional;

public class UserService {

    private static final UserService SERVICE = new UserService();

    private final UserDao userDao = UserDao.getInstance();

    private UserService() {
    }

    private final ArrayList<User> CONNECT_USERS = new ArrayList<>();

    public Optional<User> haveUser(String name, String pass) {
        Optional<User> user = userDao.findUser(name, pass);
        user.ifPresent(CONNECT_USERS::add);
        return user;
    }

    public boolean haveName(String name) {
        return userDao.findName(name);
    }

    public ArrayList<User> getConnectUsers() {
        return CONNECT_USERS;
    }

    public static UserService getInstance() {
        return SERVICE;
    }


}
