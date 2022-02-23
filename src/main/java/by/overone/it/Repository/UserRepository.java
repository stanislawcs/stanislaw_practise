package by.overone.it.Repository;

import by.overone.it.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository {

    User findUserByEmail(@Param("email") String email);
}
