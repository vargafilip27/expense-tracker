package cz.filipvarga.tracker.persistent;

import cz.filipvarga.tracker.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAEventRepository extends JpaRepository<Event, Long> {
}
