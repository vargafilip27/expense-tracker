package cz.filipvarga.tracker.persistent;

import cz.filipvarga.tracker.domain.Event;
import cz.filipvarga.tracker.domain.Expense;
import cz.filipvarga.tracker.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByEvent(Event event);
    List<Expense> findByPerson(Person person);
}
