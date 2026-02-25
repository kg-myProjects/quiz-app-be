package kg.quiz_app.model.quiz;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import kg.quiz_app.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user_answers")
public class Answer extends BaseEntity {

    @ManyToOne
    private User user;

    @ManyToOne
    private Question question;

    private boolean isCorrect;
}
