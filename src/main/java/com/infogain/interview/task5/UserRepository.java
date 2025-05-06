package com.infogain.interview.task5;

@Repository
@Data
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        if (user.getId() == 0) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    public List<User> findAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }
}