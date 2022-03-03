package by.overone.it.repository;

import by.overone.it.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,String> {
@Query("from Person where email=:email")
Person findPersonByEmail(@Param("email")String email);
}
