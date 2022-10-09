package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDao implements CRUDDao<User> {

    private final EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public void create(User user) {
        entityManager.joinTransaction();
        entityManager.persist(user);
    }

    @Override
    public User show(long id) {
        TypedQuery<User> query = entityManager.createQuery("from User where id=:id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<User> getList() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void update(long id, User user) {
        entityManager.joinTransaction();
        User userExisting = show(id);
        userExisting.setFirstName(user.getFirstName());
        userExisting.setLastName(user.getLastName());
        userExisting.setEmail(user.getEmail());
        entityManager.persist(userExisting);
    }

    @Override
    public void delete(long id) {
        entityManager.joinTransaction();
        try {
            entityManager.remove(show(id));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    public void delete(User user) {
        entityManager.joinTransaction();
        find(user).forEach(u -> entityManager.remove(u.getId()));
    }

    @Override
    public List<User> find(User user) {
        TypedQuery<User> query = entityManager.createQuery("from User where firstName=:firstName and lastName=:lastName", User.class);
        query.setParameter("firstName", user.getFirstName());
        query.setParameter("lastName", user.getLastName());
        return query.getResultList();
    }
}
