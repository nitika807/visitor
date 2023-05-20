package visitorSpring.development.JpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import visitorSpring.development.Model.Review;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
}
