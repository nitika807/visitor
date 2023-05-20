package visitorSpring.development.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Visitor {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String postCode;
    private String email;

}
