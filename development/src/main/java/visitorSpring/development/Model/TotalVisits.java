package visitorSpring.development.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TotalVisits {
    @Id
    private int id;
    private int visitNo;
    private Date date;
    private String notes;
}
