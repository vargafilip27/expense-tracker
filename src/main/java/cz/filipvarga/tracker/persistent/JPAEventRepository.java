package cz.filipvarga.tracker.persistent;

import cz.filipvarga.tracker.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JPAEventRepository extends JpaRepository<Event, Long> {
    @Query(value =
            "SELECT e " +
            "FROM Event e " +
            "JOIN e.persons p " +
            "WHERE p.id = :ref_person")
    List<Event> findAllByPersonId(@Param("ref_person") Long personId);
}
