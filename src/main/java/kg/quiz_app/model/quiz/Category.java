package kg.quiz_app.model.quiz;

import jakarta.persistence.*;
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
@Table(name = "quiz_category")
public class Category extends BaseEntity {

    private String title;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Question> questions;
}
