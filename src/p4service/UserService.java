package p4service;

import p2entity.User;
import p3dao.UserDao;

import java.util.HashMap;
import java.util.Optional;

public class UserService {

    private static final UserService SERVICE = new UserService();

    private final UserDao userDao = UserDao.getInstance();

    private UserService() {
    }

    private final HashMap<Integer, User> CONNECT_USERS = new HashMap<>();

    public Optional<User> getUser(String name, String pass) {
        return userDao.findUser(name, pass);
    }

    public void addUserToConnect(User user) {
        CONNECT_USERS.put(user.getId(), user);
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

    public void saveUser(String name, String password, boolean master) {
        userDao.registration(name, password, master);
    }

    public void logoutUser(User user) {
        CONNECT_USERS.remove(user.getId());
    }

    public static UserService getInstance() {
        return SERVICE;
    }


}
