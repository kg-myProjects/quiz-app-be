package kg.quiz_app.model.quiz;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import kg.quiz_app.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "questions")
public class Question extends BaseEntity {

    private String text;

    @ElementCollection
    private List<String> options;

    private int correctIndex;

    @ManyToOne
    private Category category;
}
