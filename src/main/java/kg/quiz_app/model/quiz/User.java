package kg.quiz_app.model.quiz;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import kg.quiz_app.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "app_users")
public class User extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Answer> userAnswers;
}
