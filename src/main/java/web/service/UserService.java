package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.CRUDDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserService implements CRUDService<User> {
    private final CRUDDao<User> dao;

    public UserService(CRUDDao<User> dao) {
        this.dao = dao;
    }

    @Override
    public void create(User user) {
        dao.create(user);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }

    @Override
    public void delete(User user) {
        dao.delete(user);
    }

    @Override
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
