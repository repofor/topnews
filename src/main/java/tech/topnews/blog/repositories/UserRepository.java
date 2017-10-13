package tech.topnews.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.topnews.blog.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    public User findByUsername(String username);
}
