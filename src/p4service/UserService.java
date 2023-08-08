package p4service;

import p2entity.User;
import p3dao.UserDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class UserService {

    private static final UserService SERVICE = new UserService();

    private final UserDao userDao = UserDao.getInstance();

    private UserService() {
    }

    private final HashMap<Integer, User> CONNECT_USERS = new HashMap<>();

    public Optional<User> haveUser(String name, String pass) {
        Optional<User> user = userDao.findUser(name, pass);
        user.ifPresent(us -> CONNECT_USERS.put(us.getId(), us));
        return user;
    }

    public boolean haveName(String name) {
        return userDao.findName(name);
    }

    public HashMap<Integer ,User> getConnectUsers() {
        return CONNECT_USERS;
    }

    public Optional<String> isUserConnectById(int id) {
        Optional<String> name = Optional.empty();
        if(CONNECT_USERS.containsKey(id)) {
            name = Optional.of(CONNECT_USERS.get(id).getName());
        }
        return name;
    }

    public void logoutUser(User user) {
        CONNECT_USERS.remove(user.getId());
    }

    public static UserService getInstance() {
        return SERVICE;
    }


}
