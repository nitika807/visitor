package visitorSpring.development.JpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import visitorSpring.development.Model.Visitor;

public interface VisitorJpaRepo extends JpaRepository<Visitor, Integer> {
}
