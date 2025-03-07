package cz.filipvarga.tracker.persistent;

import cz.filipvarga.tracker.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAPersonRepository extends JpaRepository<Person, Long> {
}
