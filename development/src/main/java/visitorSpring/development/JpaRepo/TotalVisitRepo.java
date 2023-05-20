package visitorSpring.development.JpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import visitorSpring.development.Model.TotalVisits;

public interface TotalVisitRepo extends JpaRepository<TotalVisits, Integer> {
}
