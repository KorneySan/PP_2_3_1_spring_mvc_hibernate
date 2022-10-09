package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.CRUDDao;
import web.model.User;

import java.util.List;

@Service
public class UserService implements CRUDService<User> {
    private final CRUDDao<User> dao;

    public UserService(CRUDDao<User> dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void create(User user) {
        dao.create(user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        dao.delete(id);
    }

    @Override
    @Transactional
    public void delete(User user) {
        dao.delete(user);
    }

    @Override
    @Transactional
    public void update(long id, User user) {
        dao.update(id, user);
    }

    @Override
    public User show(long id) {
        return dao.show(id);
    }

    @Override
    public List<User> find(User user) {
        return dao.find(user);
    }

    @Override
    public List<User> getList() {
        return dao.getList();
    }
}
